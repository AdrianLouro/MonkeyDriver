package monkeydriver.view;

import monkeydriver.Global;
import monkeydriver.model.Road;

/**
 * Created by gerardo on 15/11/2016.
 */
public class RoadViewConsole implements RoadView {
    Road horizontal;
    Road vertical;

    public RoadViewConsole(Road horizontal, Road vertical) {
        this.horizontal = horizontal;
        this.vertical = vertical;
    }

    public void paintRoad() {
        for (int i = 0; i < Global.ROAD_LENGTH; i++) {
            for (int j = 0; j < Global.ROAD_LENGTH; j++) {
                System.out.print(' ');
            }
            System.out.println();
        }
    }



}
