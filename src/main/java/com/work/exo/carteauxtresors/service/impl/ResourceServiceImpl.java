package com.work.exo.carteauxtresors.service.impl;

import com.work.exo.carteauxtresors.configuration.exception.CatFunctionnalException;
import com.work.exo.carteauxtresors.configuration.exception.CatTechnicalException;
import com.work.exo.carteauxtresors.enums.ErrorEnum;
import com.work.exo.carteauxtresors.service.IResourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Service
public class ResourceServiceImpl implements IResourceService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ResourceServiceImpl.class);

	public File getFile(String filePath) throws CatFunctionnalException {
		File file = new File(filePath);
		if (file.length() == 0)
			throw new CatFunctionnalException(ErrorEnum.EF001);
		return file;
	}

	public void generateFile(String filePath, String content) throws CatTechnicalException {
		try (FileWriter myWriter = new FileWriter(filePath)) {
			myWriter.write(content);
		} catch (IOException e) {
			LOGGER.error("Erreur lors de l'ecriture du fichier de sortie.");
			throw new CatTechnicalException(ErrorEnum.ET002, e);
		}
	}

}
