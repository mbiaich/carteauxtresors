package com.work.exo.carteauxtresors.configuration.exception;

import com.work.exo.carteauxtresors.enums.ErrorEnum;

public class CatFunctionnalException extends CatException {

    public CatFunctionnalException(ErrorEnum errorEnum) {
        super(errorEnum);
    }
}
