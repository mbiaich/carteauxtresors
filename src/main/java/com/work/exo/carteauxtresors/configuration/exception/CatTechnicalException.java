package com.work.exo.carteauxtresors.configuration.exception;

import com.work.exo.carteauxtresors.enums.ErrorEnum;

public class CatTechnicalException extends CatException {
    public CatTechnicalException(ErrorEnum errorEnum, Throwable cause) {
        super(errorEnum, cause);
    }
}
