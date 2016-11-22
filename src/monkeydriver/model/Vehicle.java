package monkeydriver.model;

import monkeydriver.Global;
import monkeydriver.model.bus.Bus;
import monkeydriver.model.bus.VehicleBus;

/**
 * Created by gerardo on 15/11/2016.
 */
public class Vehicle {
    private static int globalId = 0;
    private int id;

    private int length;
    private int initialRoute;
    private int finalRoute;

    private Bus bus;

    public Vehicle(int initialRoute, int finalRoute) {
        this.id = globalId++;
        this.length = Global.CAR_LENGTH;
        this.initialRoute = initialRoute;
        this.finalRoute = finalRoute;
    }
}
