package com.work.exo.carteauxtresors.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper=true)
public class Treasure extends Element {

    private int number;

}
