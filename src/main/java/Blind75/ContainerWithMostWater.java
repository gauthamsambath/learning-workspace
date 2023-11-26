package Blind75;

/**
 * The type Container with most water.
 */
public class ContainerWithMostWater {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int[] arrayOfHeightsOfBarricade = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        System.out.println("Area of the container with most water is = " + containerWithMostWater.maxArea(arrayOfHeightsOfBarricade));
    }

    /**
     * Max area int.
     *
     * @param height the height
     * @return the int
     */
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxArea = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            maxArea = Math.max(maxArea, area);
            if (height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }
}
