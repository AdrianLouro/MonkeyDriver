package monkeydriver.model;

import monkeydriver.Global;

import java.util.ArrayList;

/**
 * Created by gerardo on 15/11/2016.
 */
public class Road {

    private ArrayList<Car> obverseCars;
    private ArrayList<Car> reverseCars;
    private int length;

    public Road() {
        this.length = Global.ROAD_LENGTH;
        this.obverseCars = new ArrayList<>(Global.ROAD_LENGTH/Global.CAR_LENGTH);
        this.reverseCars = new ArrayList<>(Global.ROAD_LENGTH/Global.CAR_LENGTH);
    }


}
