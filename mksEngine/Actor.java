package mksEngine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public abstract class Actor extends Thread {

    protected final class WorldDirection {
        public final static Vector2d RIGTH = new Vector2d(1, 0);
        public final static Vector2d LEFT = Math.inverse(RIGTH);
        public final static Vector2d UP = new Vector2d(0, -1);
        public final static Vector2d DOWN = Math.inverse(UP);
    }

    protected final class Look {
        private boolean isActive;
        private BufferedImage look;
        private String name;

        public boolean isActive() {
            return isActive;
        }

        public BufferedImage getLook() {
            return look;
        }

        public String getName() {
            return name;
        }
    }

    private Vector2d location;
    private HashMap<String, Look> looks = new HashMap<>();
    private String actorName;
    private Vector2d localRightDirection = WorldDirection.RIGTH;
    private Vector2d localLeftDirection = WorldDirection.LEFT;
    private Vector2d localUpDirection = WorldDirection.UP;
    private Vector2d localDownDirection = WorldDirection.DOWN;
    private boolean isAlive = true;
    private Color areaColor = Color.black;
    private int width = 50;
    private int height = 50;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getAreaColor() {
        return areaColor;
    }

    public void setAreaColor(Color areaColor) {
        this.areaColor = areaColor;
    }

    final boolean isStillAlive() {
        return isAlive;
    }

    protected final boolean addLook(String name, String lookURL, boolean isActive) {
        try {
            looks.put(name, createNewLook(name, lookURL, isActive));
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    private final Look createNewLook(String name, String lookURL, boolean isActive) throws IOException {
        Look newLook = new Look();
        newLook.name = name;
        newLook.look = ImageIO.read(new File(lookURL));
        if (isActive)
            deActivateAllLooks();

        newLook.isActive = isActive;
        return newLook;
    }

    private void deActivateAllLooks() {
        looks.forEach((t, u) -> {
            u.isActive = false;
        });
    }

    protected final Look getLook(String name) {
        try {
            return looks.get(name);
        } catch (Exception e) {
            return null;
        }
    }

    protected Vector2d getLocalRightDirection() {
        return localRightDirection;
    }

    protected Vector2d getLocalLeftDirection() {
        return localLeftDirection;
    }

    protected Vector2d getLocalUpDirection() {
        return localUpDirection;
    }

    protected Vector2d getLocalDownDirection() {
        return localDownDirection;
    }

    protected String getActorName() {
        return actorName;
    }

    protected final void setActorName(String name) {
        this.actorName = name;
    }

    protected Vector2d getLocation() {
        return location;
    }

    protected final void setLocation(float x, float y) {
        setLocation(new Vector2d(x, y));
    }

    protected final void setLocation(Vector2d location) {
        this.location = location;
    }

    final void render(Graphics g) {
        int x = java.lang.Math.round(getLocation().getX());
        int y = java.lang.Math.round(getLocation().getY());

        if (looks.size() == 0) {
            g.setColor(getAreaColor());
            g.fillRect(x, y, getWidth(), getHeight());
        } else {
            // TODO: Draw Image here
        }
    }

    @Override
    public String toString() {
        return String.format("%s, at [%f, %f]",
                getName(), getLocation().getX(), getLocation().getY());
    }

    protected final Vector2d move(float steps, Vector2d direction) {
        var newLocation = Math.addVectors(getLocation(), Math.scaleVector(steps, direction));
        setLocation(newLocation);
        return getLocation();
    }

    protected final Vector2d moveRight(float steps) {
        var newLocation = Math.addVectors(getLocation(), Math.scaleVector(steps, WorldDirection.RIGTH));
        setLocation(newLocation);
        return getLocation();
    }

    protected final Vector2d moveLeft(float steps) {
        var newLocation = Math.addVectors(getLocation(), Math.scaleVector(steps, WorldDirection.LEFT));
        setLocation(newLocation);
        return getLocation();
    }

    protected final Vector2d moveUp(float steps) {
        var newLocation = Math.addVectors(getLocation(), Math.scaleVector(steps, WorldDirection.UP));
        setLocation(newLocation);
        return getLocation();
    }

    protected final Vector2d moveDown(float steps) {
        var newLocation = Math.addVectors(getLocation(), Math.scaleVector(steps, WorldDirection.DOWN));
        setLocation(newLocation);
        return getLocation();
    }

    protected final void turnClockwise(float degree) {
        updateLocalDirection(degree);

    }

    private final void updateLocalDirection(float degree) {
        localRightDirection = Math.rotate(degree, localRightDirection);
        localDownDirection = Math.rotate(degree, localDownDirection);
        localLeftDirection = Math.rotate(degree, localLeftDirection);
        localUpDirection = Math.rotate(degree, localUpDirection);
    }

    protected final void turnClockwiseC(float degree) {
        updateLocalDirection(degree);
        // TODO write the code here
    }

    @Override
    public final void run() {

        long lastTime = System.nanoTime();
        float deltaTime;
        while (isAlive) {
            long currentTime = System.nanoTime();
            deltaTime = (currentTime - lastTime) / 1_000_000_000.0f;
            update(deltaTime);
            lastTime = currentTime;
            try {
                Thread.sleep(Stage.FPS); // refresh 40 frame per second.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    protected abstract void update(float deltaTime);

    protected void begin() {
        setActorName("actor");
        setLocation(0, 0);
    }

    protected Actor() {
        begin();
        start();
    }

    protected final void destroy() {
        if (isAlive) {
            System.err.println("Destroy Actor " + getActorName());
            isAlive = false;
            Stage.destroyActor(this);
        }
    }

}

/*
 * public class DeltaTimeExample {
 * public static void main(String[] args) {
 * // Variable to store the last time in nanoseconds
 * long lastTime = System.nanoTime();
 * double deltaTime;
 * 
 * // Main loop (this would typically run in a game or rendering loop)
 * while (true) {
 * // Calculate the current time in nanoseconds
 * long currentTime = System.nanoTime();
 * 
 * // Calculate delta time in seconds
 * deltaTime = (currentTime - lastTime) / 1_000_000_000.0;
 * 
 * // Update lastTime to the current time for the next frame
 * lastTime = currentTime;
 * 
 * // Print deltaTime for each frame
 * System.out.printf("Delta time (seconds): %.6f%n", deltaTime);
 * 
 * // Simulate work done in the frame (replace with actual frame logic)
 * try {
 * Thread.sleep(16); // Sleep for roughly 16ms to simulate ~60 FPS
 * } catch (InterruptedException e) {
 * e.printStackTrace();
 * }
 * }
 * }
 * }
 */