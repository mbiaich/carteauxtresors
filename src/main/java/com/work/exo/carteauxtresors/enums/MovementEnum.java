package com.work.exo.carteauxtresors.enums;

public enum MovementEnum {

    D("Droite"),G("Gauche"), A("Avancer");

    private String label;

    MovementEnum(String label) {
        this.label = label;
    }
}
