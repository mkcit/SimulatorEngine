
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
    public float getX() {
        return x;
    }

    /**
     * @param x
     */
    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    /**
     * @param y
     */
    public void setY(float y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("[x, y] = [%f, %f]", getX(), getY());
    }

}