package monkeydriver;

import monkeydriver.model.Road;
import monkeydriver.view.RoadView;
import monkeydriver.view.RoadViewConsole;

/**
 * Created by gerardo on 15/11/2016.
 */
public class Main {
    public static void main(String[] args) {
        RoadView roadView = new RoadViewConsole(new Road(),new Road());
        roadView.paintRoad();
    }
}
