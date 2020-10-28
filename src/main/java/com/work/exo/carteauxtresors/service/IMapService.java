package com.work.exo.carteauxtresors.service;

import com.work.exo.carteauxtresors.configuration.exception.CatException;
import com.work.exo.carteauxtresors.model.Map;

import java.io.File;

public interface IMapService {

	/**
	 * Methode permettant à partir d'un fichier la construction de la carte avec
	 * tous les éléments
	 * 
	 * @param file
	 * @return
	 * @throws CatException
	 */
	Map buildMap(File file) throws CatException;

	/**
	 * Methode permettant de lancer les mouvements des personnages
	 * 
	 * @param map
	 */
	void startMovement(Map map);

	/**
	 * Methode permettant de construire le contenu du fichier de sortie via les
	 * données de la carte
	 * 
	 * @param map
	 * @return
	 */
	String buildOutputContent(Map map);

}
