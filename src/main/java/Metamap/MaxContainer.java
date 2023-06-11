package Metamap;


public class MaxContainer {
    public static void main(String[] args) {
        int []height = {1,8,6,2,5,4,8,3,7};
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i+1; j < height.length; j++) {
                int minHeight = Math.min(height[i],height[j]);
                maxArea = Math.max(maxArea,minHeight*(j-i));
            }
        }

        int start = 0;
        int end = height.length-1;
        int min = Math.min(height[start],height[end]);
        int area = min*(end-1-start);
        int previousArea = 0;
        int i =1;
        int j =0;
        while(j<height.length) {
            area = Math.max(area,Math.min(height[start+i],height[end-i])*((end-i)-(start+i)));
            if (previousArea<area) {
                previousArea = area;
                start =start+i;
                end = end-i;
            }
            area = Math.max(area,Math.min(height[start],height[end-i])*((end-i)-(start)));
            if (previousArea<area) {
                previousArea = area;
                end = end-i;
            }
            area = Math.max(area,Math.min(height[start+i],height[end])*((end)-(start+i)));
            if (previousArea<area) {
                previousArea = area;
                start =start+i;
            }
            j++;
        }
        System.out.println("max possible area is = "+maxArea);
        System.out.println("max possible are optimum approach is = "+previousArea);
    }
}
