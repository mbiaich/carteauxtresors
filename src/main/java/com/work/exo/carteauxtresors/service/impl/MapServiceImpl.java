package com.work.exo.carteauxtresors.service.impl;

import com.work.exo.carteauxtresors.configuration.exception.CatException;
import com.work.exo.carteauxtresors.configuration.exception.CatFunctionnalException;
import com.work.exo.carteauxtresors.configuration.exception.CatTechnicalException;
import com.work.exo.carteauxtresors.enums.ErrorEnum;
import com.work.exo.carteauxtresors.enums.OrientationEnum;
import com.work.exo.carteauxtresors.enums.MovementEnum;
import com.work.exo.carteauxtresors.enums.TypeElementEnum;
import com.work.exo.carteauxtresors.model.Adventurer;
import com.work.exo.carteauxtresors.model.Map;
import com.work.exo.carteauxtresors.model.Mountain;
import com.work.exo.carteauxtresors.model.Treasure;
import com.work.exo.carteauxtresors.service.IMapService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

@Service
public class MapServiceImpl implements IMapService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MapServiceImpl.class);

	public Map buildMap(File file) throws CatException {
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String st;
			Map map = new Map();
			while ((st = br.readLine()) != null) {
				if (!st.startsWith("#")) {
					buildMap(st, map);
				}
			}
			return map;
		} catch (IOException e) {
			throw new CatTechnicalException(ErrorEnum.ET001, e);
		}
	}

	public void startMovement(Map map) {
		map.getAdventurerList().forEach(adventurer -> Arrays.asList(adventurer.getTrip().split("")).forEach(s -> {
			if (MovementEnum.D.name().equals(s) || MovementEnum.G.name().equals(s)) {
				adventurer.turn(MovementEnum.valueOf(s));
			} else if (MovementEnum.A.name().equals(s)) {
				adventurer.move(map);
			} else {
				LOGGER.error(String.format("Mouvement inconnu : %s - aventurier : %s.", s,
						adventurer.getName()));
			}
		}));
	}

	public String buildOutputContent(Map map) {
		StringBuilder sb = new StringBuilder();
		sb.append(String.join(" - ", "C", String.valueOf(map.getNbColumn()), String.valueOf(map.getNbLine()))
				+ System.lineSeparator());
		map.getMountainList()
				.forEach(mountain -> sb.append(
						String.join(" - ", "M", String.valueOf(mountain.getPosX()), String.valueOf(mountain.getPosY()))
								+ System.lineSeparator()));
		if (map.getTreasureList().stream().anyMatch(treasure -> treasure.getNumber() > 0)) {
			sb.append(String.join(" - ", "# {T comme Trésor}", "{Axe horizontal}", "{Axe vertical}",
					"{Nb. de trésors restants}") + System.lineSeparator());
			map.getTreasureList().stream().filter(treasure -> treasure.getNumber() > 0)
					.forEach(treasure -> sb.append(String.join(" - ", "T", String.valueOf(treasure.getPosX()),
							String.valueOf(treasure.getPosY()), String.valueOf(treasure.getNumber()))
							+ System.lineSeparator()));
		}
		if (!map.getAdventurerList().isEmpty()) {
			sb.append(String.join(" - ", "# {A comme Aventurier}", "{Nom de l’aventurier}", "{Axe horizontal}",
					"{Axe vertical}", "{Orientation}", "{Nb. trésors ramassés}") + System.lineSeparator());
			map.getAdventurerList()
					.forEach(adventurer -> sb
							.append(String.join(" - ", "A", adventurer.getName(), String.valueOf(adventurer.getPosX()),
									String.valueOf(adventurer.getPosY()), adventurer.getOrientation().name(),
									String.valueOf(adventurer.getNbTreasure())) + System.lineSeparator()));
		}
		return sb.toString();
	}

	private void buildMap(String line, Map map) throws CatException {
		String type = line.split(" - ")[0];
		TypeElementEnum typeElementEnum = TypeElementEnum.valueOf(type);
		switch (typeElementEnum) {
			case C :
				setDataToMap(line, map);
				break;
			case M :
				addMountainToMap(line, map);
				break;
			case T :
				addTreasureToMap(line, map);
				break;
			case A :
				addAdventurerToMap(line, map);
				break;
			default :
				LOGGER.error(String.format("Cas non pris en charge : %s - ligne %s.", type, line));
				throw new CatFunctionnalException(ErrorEnum.EF002);
		}
	}

	private void setDataToMap(String line, Map map) throws CatTechnicalException {
		try {
			String[] data = line.split(" - ");
			map.setNbColumn(Integer.parseInt(data[1]));
			map.setNbLine(Integer.parseInt(data[2]));
		} catch (Exception e) {
			throw new CatTechnicalException(ErrorEnum.ET003, e);
		}

	}

	private void addMountainToMap(String line, Map map) throws CatTechnicalException {
		try {
			String[] data = line.split(" - ");
			Mountain mountain = new Mountain();
			mountain.setPosX(Integer.parseInt(data[1]));
			mountain.setPosY(Integer.parseInt(data[2]));
			map.getMountainList().add(mountain);
		} catch (Exception e) {
			throw new CatTechnicalException(ErrorEnum.ET004, e);
		}
	}

	private void addTreasureToMap(String line, Map map) throws CatTechnicalException {
		try {
			String[] data = line.split(" - ");
			Treasure treasure = new Treasure();
			treasure.setPosX(Integer.parseInt(data[1]));
			treasure.setPosY(Integer.parseInt(data[2]));
			treasure.setNumber(Integer.parseInt(data[3]));
			map.getTreasureList().add(treasure);
		} catch (Exception e) {
			throw new CatTechnicalException(ErrorEnum.ET005, e);
		}
	}

	private void addAdventurerToMap(String line, Map map) throws CatTechnicalException {
		try {
			String[] data = line.split(" - ");
			Adventurer adventurer = new Adventurer();
			adventurer.setName(data[1]);
			adventurer.setPosX(Integer.parseInt(data[2]));
			adventurer.setPosY(Integer.parseInt(data[3]));
			adventurer.setOrientation(OrientationEnum.valueOf(data[4]));
			adventurer.setTrip(data[5]);
			map.getAdventurerList().add(adventurer);
		} catch (Exception e) {
			throw new CatTechnicalException(ErrorEnum.ET006, e);
		}
	}

}
