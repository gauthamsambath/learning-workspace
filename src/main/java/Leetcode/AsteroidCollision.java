package Leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * The type Asteroid collision.
 */
public class AsteroidCollision {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int[] arrayofAsteroids = {10,2,-5};
        AsteroidCollision asteroidCollision = new AsteroidCollision();
        System.out.println("The final array after collision is = " + Arrays.toString(asteroidCollision.asteroidCollision(arrayofAsteroids)));
    }

    /**
     * Asteroid collision int [ ].
     *
     * @param asteroids the asteroids
     * @return the int [ ]
     */
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> collisionStack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (!collisionStack.isEmpty()) {
                boolean asteroidRemoved = false;
                while (!collisionStack.isEmpty() && canCollide(asteroids[i], collisionStack.peek())) {
                    if (Math.abs(asteroids[i]) > Math.abs(collisionStack.peek())) {
                        collisionStack.pop();
                    } else if (Math.abs(asteroids[i]) == Math.abs(collisionStack.peek())) {
                        collisionStack.pop();
                        asteroidRemoved = true;
                        break;

                    } else {
                        asteroidRemoved = true;
                        break;
                    }
                }

                if (!asteroidRemoved) {
                    collisionStack.push(asteroids[i]);
                }
            } else {
                collisionStack.push(asteroids[i]);
            }
        }

        int finalArraySize = collisionStack.size();
        int[] finalArray = new int[finalArraySize];
        for (int i = finalArraySize - 1; i >= 0; i--) {
            finalArray[i] = collisionStack.pop();
        }
        return finalArray;
    }

    /**
     * Is sign different boolean.
     *
     * @param asteroid the asteroid
     * @param peek     the peek
     * @return the boolean
     */
    private boolean canCollide(int asteroid, Integer peek) {
        return asteroid < 0 && peek > 0;
    }
}
