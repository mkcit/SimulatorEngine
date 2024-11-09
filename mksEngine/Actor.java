package mksEngine;

import java.awt.Graphics;
import java.awt.Image;

public abstract class Actor extends Thread {

    private Vector2d location;
    private Image image;
    private String actorName;
    private Vector2d localRightDirection = WorldDirection.RIGTH;
    private Vector2d localLeftDirection = WorldDirection.LEFT;
    private Vector2d localUpDirection = WorldDirection.UP;
    private Vector2d localDownDirection = WorldDirection.DOWN;

    public Vector2d getLocalRightDirection() {
        return localRightDirection;
    }

    public Vector2d getLocalLeftDirection() {
        return localLeftDirection;
    }

    public Vector2d getLocalUpDirection() {
        return localUpDirection;
    }

    public Vector2d getLocalDownDirection() {
        return localDownDirection;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String name) {
        this.actorName = name;
    }

    public Vector2d getLocation() {
        return location;
    }

    public void setLocation(Vector2d location) {
        this.location = location;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    void render(Graphics g) {
        int x = java.lang.Math.round(getLocation().getX());
        int y = java.lang.Math.round(getLocation().getY());
        g.drawRect(x, y, 100, 100);
    }

    @Override
    public String toString() {
        return String.format("%s, at [%f, %f]",
                getName(), getLocation().getX(), getLocation().getY());
    }

    public class WorldDirection {
        public final static Vector2d RIGTH = new Vector2d(1, 0);
        public final static Vector2d LEFT = Math.inverse(RIGTH);
        public final static Vector2d UP = new Vector2d(0, -1);
        public final static Vector2d DOWN = Math.inverse(UP);
    }

    public Vector2d move(float steps, Vector2d direction) {
        var newLocation = Math.addVectors(getLocation(), Math.scaleVector(steps, direction));
        setLocation(newLocation);
        return getLocation();
    }

    public Vector2d moveRight(float steps) {
        var newLocation = Math.addVectors(getLocation(), Math.scaleVector(steps, WorldDirection.RIGTH));
        setLocation(newLocation);
        return getLocation();
    }

    public Vector2d moveLeft(float steps) {
        var newLocation = Math.addVectors(getLocation(), Math.scaleVector(steps, WorldDirection.LEFT));
        setLocation(newLocation);
        return getLocation();
    }

    public Vector2d moveUp(float steps) {
        var newLocation = Math.addVectors(getLocation(), Math.scaleVector(steps, WorldDirection.UP));
        setLocation(newLocation);
        return getLocation();
    }

    public Vector2d moveDown(float steps) {
        var newLocation = Math.addVectors(getLocation(), Math.scaleVector(steps, WorldDirection.DOWN));
        setLocation(newLocation);
        return getLocation();
    }

    public void turnClockwise(float degree) {
        updateLocalDirection(degree);

    }

    private void updateLocalDirection(float degree) {
        localRightDirection = Math.rotate(degree, localRightDirection);
        localDownDirection = Math.rotate(degree, localDownDirection);
        localLeftDirection = Math.rotate(degree, localLeftDirection);
        localUpDirection = Math.rotate(degree, localUpDirection);
    }

    public void turnClockwiseC(float degree) {
        updateLocalDirection(degree);

    }

    @Override
    public final void run() {
        while (true) {
            update();
        }
    }

    protected abstract void update();

}
