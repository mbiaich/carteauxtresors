package com.work.exo.carteauxtresors.configuration.exception;

import com.work.exo.carteauxtresors.enums.ErrorEnum;

public class CatFunctionalException extends CatException {

    public CatFunctionalException(ErrorEnum errorEnum) {
        super(errorEnum);
    }
}
