package com.work.exo.carteauxtresors.service.impl;

import com.work.exo.carteauxtresors.configuration.AppConfig;
import com.work.exo.carteauxtresors.configuration.exception.CatException;
import com.work.exo.carteauxtresors.model.Map;
import com.work.exo.carteauxtresors.service.IGlobalService;
import com.work.exo.carteauxtresors.service.IMapService;
import com.work.exo.carteauxtresors.service.IResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class GlobalServiceImpl implements IGlobalService {

    private final IResourceService resourceService;
    private final AppConfig appConfig;
    private final IMapService mapService;

    @Autowired
    public GlobalServiceImpl(IResourceService resourceService, AppConfig appConfig, IMapService mapService) {
        this.resourceService = resourceService;
        this.appConfig = appConfig;
        this.mapService = mapService;
    }

    public void launch() throws CatException {
        File file = resourceService.getFile(appConfig.inputFilePath);
        Map map = mapService.buildMap(file);
        mapService.startMovement(map);
        String outputContent = mapService.buildOutputContent(map);
        resourceService.generateFile(appConfig.outputFilePath, outputContent);
    }

}
