package com.work.exo.carteauxtresors.service.impl;

import com.work.exo.carteauxtresors.configuration.exception.CatFunctionalException;
import com.work.exo.carteauxtresors.enums.ErrorEnum;
import com.work.exo.carteauxtresors.service.IResourceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class ResourceServiceImplTest {

    @Autowired
    IResourceService resourceService;

    @Test
    public void testGetFileThrowsCatFunctionalExceptionEF001() {
        String file = "com/work/exo/carteauxtresors/resources/EmptyFile.txt";
        Throwable exception = assertThrows(CatFunctionalException.class, () -> resourceService.getFile(file));
        assertEquals(ErrorEnum.EF001.getLibelle(), exception.getMessage());
    }
}