import java.awt.Color;

public class Bar2 extends Bar {

    @Override
    protected void begin() {
        // super.begin();

        speed = 2;
        setLocation(20, 0);
        setWidth(10);
        setHeight(400);
        setAreaColor(Color.green);

    }

}
