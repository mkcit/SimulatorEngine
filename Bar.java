
import java.awt.Color;

import mksEngine.Actor;
import mksEngine.Vector2d;
import static mksEngine.Math.*;

public class Bar extends Actor {

    protected float speed;
    protected int targetX;
    protected int targetY;

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

        targetX = 850;
        targetY = 450;

    }

    float timer = 0;
    private Vector2d lerp;
    float value = 0.5f;
    float counter = 1;

    @Override
    protected void update(float deltaTime) {
        // System.err.println(clamp(deltaTime * 100000, 10, 100));
        // timer += deltaTime;
        // if (timer >= 0.5) {
        // value += (0.2f * counter);
        // counter += 0.2f;
        // timer = 0;
        // }

        // timer += deltaTime;

        lerp = lerp(getLocation(),
                new Vector2d(targetX, targetY),
                deltaTime);

        setLocation(lerp);
        // System.out.println(lerp);
    }

}
