package mksEngine;

public class Math {
    public static Vector2d AddVectors(Vector2d vec1, Vector2d vec2) {
        return new Vector2d(vec1.getX() + vec2.getX(), vec1.getY() + vec2.getY());
    }
}
