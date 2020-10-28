package com.work.exo.carteauxtresors.model;

import com.work.exo.carteauxtresors.enums.OrientationEnum;
import com.work.exo.carteauxtresors.enums.MovementEnum;
import lombok.Data;

@Data
public class Adventurer extends Element {

	private String name;
	private OrientationEnum orientation;
	private String trip;
	private int nbTreasure = 0;

	public void turn(MovementEnum value) {
		if (OrientationEnum.N.equals(this.orientation) && MovementEnum.D.equals(value)) {
			this.setOrientation(OrientationEnum.E);
		} else if (OrientationEnum.N.equals(this.orientation) && MovementEnum.G.equals(value)) {
			this.setOrientation(OrientationEnum.O);
		} else if (OrientationEnum.S.equals(this.orientation) && MovementEnum.D.equals(value)) {
			this.setOrientation(OrientationEnum.O);
		} else if (OrientationEnum.S.equals(this.orientation) && MovementEnum.G.equals(value)) {
			this.setOrientation(OrientationEnum.E);
		} else if (OrientationEnum.E.equals(this.orientation) && MovementEnum.D.equals(value)) {
			this.setOrientation(OrientationEnum.S);
		} else if (OrientationEnum.E.equals(this.orientation) && MovementEnum.G.equals(value)) {
			this.setOrientation(OrientationEnum.N);
		} else if (OrientationEnum.O.equals(this.orientation) && MovementEnum.D.equals(value)) {
			this.setOrientation(OrientationEnum.N);
		} else if (OrientationEnum.O.equals(this.orientation) && MovementEnum.G.equals(value)) {
			this.setOrientation(OrientationEnum.S);
		}
	}

	public void move(Map map) {
		if (OrientationEnum.S.equals(this.orientation)) {
			int newPosY = this.getPosY() + 1;
			if (map.arePosXAndPosYInMap(this.getPosX(), newPosY)
					&& !map.hasMountainInPosXAndPosY(this.getPosX(), newPosY)) {
				if (map.hasTreasureListInPosXAndPosY(this.getPosX(), newPosY)) {
					map.substractNbTreasureInPosXAndPosY(this.getPosX(), newPosY);
					this.setNbTreasure(this.getNbTreasure() + 1);
				}
				this.setPosY(newPosY);
			}
		}
		if (OrientationEnum.N.equals(this.orientation)) {
			int newPosY = this.getPosY() - 1;
			if (map.arePosXAndPosYInMap(this.getPosX(), newPosY)
					&& !map.hasMountainInPosXAndPosY(this.getPosX(), newPosY)) {
				if (map.hasTreasureListInPosXAndPosY(this.getPosX(), newPosY)) {
					map.substractNbTreasureInPosXAndPosY(this.getPosX(), newPosY);
					this.setNbTreasure(this.getNbTreasure() + 1);
				}
				this.setPosY(newPosY);
			}
		}
		if (OrientationEnum.E.equals(this.orientation)) {
			int newPosX = this.getPosX() + 1;
			if (map.arePosXAndPosYInMap(newPosX, this.getPosY())
					&& !map.hasMountainInPosXAndPosY(newPosX, this.getPosY())) {
				if (map.hasTreasureListInPosXAndPosY(newPosX, this.getPosY())) {
					map.substractNbTreasureInPosXAndPosY(newPosX, this.getPosY());
					this.setNbTreasure(this.getNbTreasure() + 1);
				}
				this.setPosX(newPosX);
			}
		}
		if (OrientationEnum.O.equals(this.orientation)) {
			int newPosX = this.getPosX() - 1;
			if (map.arePosXAndPosYInMap(newPosX, this.getPosY())
					&& !map.hasMountainInPosXAndPosY(newPosX, this.getPosY())) {
				if (map.hasTreasureListInPosXAndPosY(newPosX, this.getPosY())) {
					map.substractNbTreasureInPosXAndPosY(newPosX, this.getPosY());
					this.setNbTreasure(this.getNbTreasure() + 1);
				}
				this.setPosX(newPosX);
			}
		}
	}

}
