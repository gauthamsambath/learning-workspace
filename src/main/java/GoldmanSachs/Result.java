package GoldmanSachs;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The type Result.
 */
public class Result {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        String colour = "101111010110011011100100";
        List<String> pixels = new ArrayList<>();
        pixels.add(colour);
        System.out.println("List of closest colours are " + closestColor(pixels));
    }

    /*
     * Complete the 'closestColor' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY pixels as parameter.
     */

    /**
     * Closest color list.
     *
     * @param pixels the pixels
     * @return the list
     */
    public static List<String> closestColor(List<String> pixels) {
        List<String> closestColours = new ArrayList<>();
        Map<String, List<Integer>> basicColourMap = Stream.of(new Object[][]{
                {"Black", Arrays.asList(0, 0, 0)},
                {"White", Arrays.asList(255, 255, 255)},
                {"Red", Arrays.asList(255, 0, 0)},
                {"Green", Arrays.asList(0, 255, 0)},
                {"Blue", Arrays.asList(0, 0, 255)},
        }).collect(Collectors.toMap(
                data -> (String) data[0],
                data -> (List<Integer>) data[1]
        ));

        for (String pixel : pixels) {
            List<Integer> convertedColours = getIntegerPixelValuesFromBinary(pixel);
            String closestColourToTheGivenPixel = getClosestColourString(convertedColours, basicColourMap);
            closestColours.add(closestColourToTheGivenPixel);
        }

        return closestColours;
    }

    /**
     * Gets closest colour string.
     *
     * @param convertedColours the converted colours
     * @param basicColourMap   the basic colour map
     * @return the closest colour string
     */
    private static String getClosestColourString(List<Integer> convertedColours, Map<String, List<Integer>> basicColourMap) {
        List<ColourDistance> colourDistanceList = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> entry : basicColourMap.entrySet()) {
            double distanceBetweenPixelAndBasicPixels = findDistanceBetWeenPixelAndBasicPixel(entry.getValue(), convertedColours);
            ColourDistance colourDistance = new ColourDistance(entry.getKey(), distanceBetweenPixelAndBasicPixels);
            colourDistanceList.add(colourDistance);
        }
        Collections.sort(colourDistanceList);
        if (colourDistanceList.get(4).colourDistance == colourDistanceList.get(3).colourDistance) {
            return "Ambiguous";
        } else {
            return colourDistanceList.get(4).colourName;
        }
    }

    /**
     * Find distance bet ween pixel and basic pixel double.
     *
     * @param basicValue       the basic value
     * @param convertedColours the converted colours
     * @return the double
     */
    private static double findDistanceBetWeenPixelAndBasicPixel(List<Integer> basicValue, List<Integer> convertedColours) {
        return Math.sqrt(Math.pow((basicValue.get(0) - convertedColours.get(0)), 2) + Math.pow((basicValue.get(1) - convertedColours.get(1)), 2) + Math.pow((basicValue.get(2) - convertedColours.get(2)), 2));
    }

    /**
     * Gets integer pixel values from binary.
     *
     * @param pixel the pixel
     * @return the integer pixel values from binary
     */
    private static List<Integer> getIntegerPixelValuesFromBinary(String pixel) {
        Integer red = Integer.parseInt(pixel.substring(0, 8), 2);
        Integer green = Integer.parseInt(pixel.substring(8, 16), 2);
        Integer blue = Integer.parseInt(pixel.substring(16, 24), 2);
        List<Integer> pixelIntegerList = Arrays.asList(red, green, blue);
        return pixelIntegerList;
    }

    /**
     * The type Colour distance.
     */
    static class ColourDistance implements Comparable<ColourDistance> {
        /**
         * The Colour name.
         */
        String colourName;
        /**
         * The Colour distance.
         */
        double colourDistance;

        /**
         * Instantiates a new Colour distance.
         *
         * @param colourName     the colour name
         * @param colourDistance the colour distance
         */
        public ColourDistance(String colourName, double colourDistance) {
            this.colourName = colourName;
            this.colourDistance = colourDistance;
        }

        /**
         * Compare to int.
         *
         * @param other the other
         * @return the int
         */
// Implement compareTo method to define the natural ordering based on colourDistance
        @Override
        public int compareTo(ColourDistance other) {
            return Double.compare(other.colourDistance, this.colourDistance);
        }

    }

}
