package mksEngine;

public class Math {
    private static Vector2d subVectors;

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
        float magnitude = distance(vec);
        if (magnitude != 0)
            return new Vector2d(vec.getX() / magnitude, vec.getY() / magnitude);
        return new Vector2d(0, 0);
    }

    public static float distance(Vector2d vec1, Vector2d vec2) {
        Vector2d nVector = subVectors(vec1, vec2);

        return (float) java.lang.Math.sqrt(nVector.getX() * nVector.getX() + nVector.getY() * nVector.getY());
    }

    public static float distance(Vector2d vec) {
        return (float) distance(new Vector2d(0, 0), vec);
    }

    /**
     * @param degree
     * @param direction
     * @return
     */
    public static Vector2d rotate(float degree, Vector2d vec) {
        float angleRadian = (float) java.lang.Math.toRadians(degree);

        float newX = (float) (vec.getX() *
                java.lang.Math.cos(angleRadian) -
                vec.getY() * java.lang.Math.sin(angleRadian));

        float newY = (float) (vec.getX() *
                java.lang.Math.sin(angleRadian) +
                vec.getY() * java.lang.Math.cos(angleRadian));
        return new Vector2d(newX, newY);
    }

    public static float angleBetween(Vector2d vec1, Vector2d vec2) {
        float dotProduct = dotProduct(vec1, vec2);
        float magnitude1 = distance(vec1);
        float magnitude2 = distance(vec2);

        float cosTheta = dotProduct / (magnitude1 * magnitude2);

        return (float) java.lang.Math.toDegrees(
                java.lang.Math.acos(cosTheta));
    }

    public static float dotProduct(Vector2d vec1, Vector2d vec2) {
        return vec1.getX() * vec2.getX() + vec1.getY() * vec2.getY();
    }

    public static Vector2d lerp(Vector2d source, Vector2d target, float time) {
        time = java.lang.Math.max(0, java.lang.Math.min(1, time)); // Clamp time to the [0 and 1]
        float newX = source.getX() + time * (target.getX() - source.getX());
        float newY = source.getY() + time * (target.getY() - source.getY());

        return new Vector2d(newX, newY);
    }

    public static final Vector2d reflect(Vector2d incomeVec, Vector2d normalVec) {
        Vector2d normalVector = normalize(normalVec);
       //Vector2d incomeVector = normalize(incomeVec);

        float dotProduct = dotProduct(normalVector, incomeVec);

        float reflectX = incomeVec.getX() - 2 * dotProduct * normalVector.getX();
        float reflectY = incomeVec.getY() - 2 * dotProduct * normalVector.getY();

        return new Vector2d(reflectX, reflectY);
    }

}
