
import java.awt.Color;

import mksEngine.Actor;
import mksEngine.Vector2d;
import static mksEngine.Math.*;

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

        // float dotProduct = dotProduct(new Vector2d(0.7f, 0.7f),
        // new Vector2d(-0.7f, -0.7f));
        // System.err.println(dotProduct);

        Vector2d reflect = reflect(new Vector2d(-150, 20), new Vector2d(1, 1));
        System.err.println(reflect);

    }

    float timer = 0;
    private Vector2d lerp;

    @Override
    protected void update(float deltaTime) {

        // timer += deltaTime;

        // lerp = mksEngine.Math.lerp(getLocation(), new Vector2d(850, 0), deltaTime *
        // 3);

        // setLocation(lerp);
        // System.out.println(lerp);
    }

}
