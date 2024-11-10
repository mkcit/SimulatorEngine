
import java.awt.Color;

import mksEngine.Actor;
import mksEngine.Vector2d;

public class Bar extends Actor {

    protected float speed;

    @Override
    protected void begin() {
        speed = 1;
        setActorName("Bar1");
        setLocation(0, 0);

        // destroy();

        setWidth(10);
        setHeight(250);
        setAreaColor(Color.red);
        // addLook(getActorName() + "-1", "", true);

    }

    @Override
    protected void update() {
        move(speed, WorldDirection.RIGTH);
        // if (getLocation().getX() > 50) {
        // destroy();
        // }
        // System.err.println(getLocation());
    }

}
