package com.work.exo.carteauxtresors.service;

import com.work.exo.carteauxtresors.configuration.exception.CatException;

public interface IGlobalService {

	/**
	 * Methode pour lancer toutes les étapes
	 * 
	 * @throws CatException
	 */
	void launch() throws CatException;

}
