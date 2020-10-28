package com.work.exo.carteauxtresors.configuration.exception;

import com.work.exo.carteauxtresors.enums.ErrorEnum;

public class CatException extends Exception {

    public CatException(ErrorEnum errorEnum, Throwable cause) {
        super(errorEnum.getLibelle(), cause);
    }

    public CatException(ErrorEnum errorEnum) {
        super(errorEnum.getLibelle());
    }

}
