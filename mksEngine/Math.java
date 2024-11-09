package mksEngine;

public class Math {
    /**
     * @param vec1
     * @param vec2
     * @return
     */
    public static Vector2d addVectors(Vector2d vec1, Vector2d vec2) {
        return new Vector2d(vec1.getX() + vec2.getX(), vec1.getY() + vec2.getY());
    }

    /**
     * @param fisrtVector
     * @param lastVector
     * @return
     */
    public static Vector2d subVectors(Vector2d fisrtVector, Vector2d lastVector) {
        return new Vector2d(lastVector.getX() - fisrtVector.getX(), lastVector.getY() - fisrtVector.getY());
    }

    /**
     * @param vec
     * @return
     */
    public static Vector2d inverse(Vector2d vec) {
        return new Vector2d(vec.getX() * -1, vec.getY() * -1);
    }

    /**
     * @param value
     * @param vec
     * @return
     */
    public static Vector2d scaleVector(float value, Vector2d vec) {
        return new Vector2d(value * vec.getX(), value * vec.getY());
    }

    /**
     * @param vec
     * @return
     */
    public static Vector2d normalize(Vector2d vec) {
        //return new Vector2d(value * vec.getX(), value * vec.getY());
        return null;
    }

    /**
     * @param degree
     * @param direction
     * @return
     */
    public static Vector2d rotate(float degree, Vector2d direction) {
        
        return null;
    }

}
