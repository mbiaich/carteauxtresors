package com.work.exo.carteauxtresors.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
public class Map {

	private int nbColumn;
	private int nbLine;
	private List<Adventurer> adventurerList = new ArrayList<>();
	private List<Mountain> mountainList = new ArrayList<>();
	private List<Treasure> treasureList = new ArrayList<>();

	public boolean hasMountainInPosXAndPosY(int posX, int posY) {
		return this.mountainList.stream()
				.anyMatch(mountain -> mountain.getPosX() == posX && mountain.getPosY() == posY);
	}

	public boolean hasTreasureListInPosXAndPosY(int posX, int posY) {
		return this.treasureList.stream()
				.anyMatch(treasure -> treasure.getPosX() == posX && treasure.getPosY() == posY);
	}

	public void substractNbTreasureInPosXAndPosY(int posX, int posY) {
		Optional<Treasure> treasureForSubstractOptional = this.treasureList.stream()
				.filter(treasure -> treasure.getPosX() == posX && treasure.getPosY() == posY).findFirst();
		if (treasureForSubstractOptional.isPresent()) {
			Treasure treasureForSubstract = treasureForSubstractOptional.get();
			treasureForSubstract.setNumber(treasureForSubstract.getNumber() - 1);
		}
	}

	public boolean arePosXAndPosYInMap(int posX, int posY) {
		return posX >= 0 && posX < this.getNbColumn() && posY >= 0 && posY < this.getNbLine();
	}

}
