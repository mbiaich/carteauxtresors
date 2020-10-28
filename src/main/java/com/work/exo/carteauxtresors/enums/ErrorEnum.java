package com.work.exo.carteauxtresors.enums;

import lombok.Getter;

@Getter
public enum ErrorEnum {

	ET001("Problème lors de la lecture du fichier"),
	ET002("Problème lors de la lecture du fichier"),
	ET003("Erreur technique au set du nombre de ligne et de colonne de la map"),
	ET004("Erreur technique lors de l'ajout d'une montagne à la map"),
	ET005("Erreur technique lors de l'ajout d'un trésor à la map"),
	ET006("Erreur technique lors de l'ajout d'un personnage à la map"),

	EF001("Fichier vide"),
	EF002("Type d'élément non pris en charge");

	private String libelle;

	ErrorEnum(String libelle) {
		this.libelle = libelle;
	}
}
