
package mksEngine;

public class Vector2d {
    private float x;
    private float y;

    /**
     * @param x
     * @param y
     */
    public Vector2d(float x, float y) {

        setX(x);
        setY(y);
    }

    /**
     * @return 
     */
    public final float getX() {
        return x;
    }

    /**
     * @param x
     */
    public final void setX(float x) {
        this.x = x;
    }

    public final float getY() {
        return y;
    }

    /**
     * @param y
     */
    public final void setY(float y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("[x, y] = [%f, %f]", getX(), getY());
    }

}