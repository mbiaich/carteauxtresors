package com.work.exo.carteauxtresors.service;

import com.work.exo.carteauxtresors.configuration.exception.CatFunctionalException;
import com.work.exo.carteauxtresors.configuration.exception.CatTechnicalException;

import java.io.File;

public interface IResourceService {

	/**
	 * Methode permettant de récupérer le fichier à partir du chemin en paramètre
	 * 
	 * @param filePath
	 * @return
	 */
	File getFile(String filePath) throws CatFunctionalException;

	/**
	 * Methode permettant de générer le fichier de sortie
	 * 
	 * @param filePath
	 * @param content
	 * @throws CatTechnicalException
	 */
	void generateFile(String filePath, String content) throws CatTechnicalException;
}
