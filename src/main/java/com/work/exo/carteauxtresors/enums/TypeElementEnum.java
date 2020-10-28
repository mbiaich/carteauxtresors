package com.work.exo.carteauxtresors.enums;

public enum TypeElementEnum {

    C("Carte"),T("Trésor"),M("Montagne"),A("Aventurier");

    private String label;

    TypeElementEnum(String label) {
        this.label = label;
    }
}
