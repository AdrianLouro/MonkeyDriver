package monkeydriver.model;

import monkeydriver.Global;

import java.util.ArrayList;

/**
 * Created by gerardo on 15/11/2016.
 */
public class Road {

    private ArrayList<Vehicle> obverseVehicles;
    private ArrayList<Vehicle> reverseVehicles;
    private int length;

    public Road() {
        this.length = Global.ROAD_LENGTH;
        this.obverseVehicles = new ArrayList<>(Global.ROAD_LENGTH/Global.CAR_LENGTH);
        this.reverseVehicles = new ArrayList<>(Global.ROAD_LENGTH/Global.CAR_LENGTH);
    }


}
