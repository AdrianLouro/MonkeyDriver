package monkeydriver.model;

import monkeydriver.Global;

/**
 * Created by gerardo on 15/11/2016.
 */
public class Car {
    private static int globalId = 0;
    private int id;

    private int speed;
    private int length;

    private int initialRoute;
    private int finalRoute;

    public Car(int initialRoute, int finalRoute) {
        this.id = globalId++;
        this.speed = Global.MAX_SPEED;
        this.length = Global.CAR_LENGTH;
        this.initialRoute = initialRoute;
        this.finalRoute = finalRoute;
    }
}
