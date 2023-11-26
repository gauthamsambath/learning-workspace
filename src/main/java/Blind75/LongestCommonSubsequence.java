package Blind75;

/**
 * The type Longest common subsequence.
 */
public class LongestCommonSubsequence {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        System.out.println("length of the longest common sub-sequence among " +
                "the strings " + text1 + " and " + text2 + " is " + longestCommonSubsequence.longestCommonSubsequence(text1, text2));

        System.out.println("length of the longest common sub-sequence among " +
                "the strings " + text1 + " and " + text2 + " in the optimized method is " + longestCommonSubsequence.longestCommonSubsequenceOptimized(text1, text2));
    }

    /**
     * Longest common subsequence int.
     *
     * @param text1 the text 1
     * @param text2 the text 2
     * @return the int
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int row = text1.length() + 1;
        int column = text2.length() + 1;
        int[][] commonSubSequenceMatrix = new int[row][column];

        for (int i = 1; i < row; i++) {
            char testChar = text1.charAt(i - 1);
            for (int j = 1; j < column; j++) {
                if (testChar == text2.charAt(j - 1)) {
                    commonSubSequenceMatrix[i][j] = commonSubSequenceMatrix[i - 1][j - 1] + 1;
                } else {
                    commonSubSequenceMatrix[i][j] = Math.max(commonSubSequenceMatrix[i][j - 1], commonSubSequenceMatrix[i - 1][j]);
                }
            }
        }
        return commonSubSequenceMatrix[row - 1][column - 1];
    }

    /**
     * Longest common subsequence optimized int.
     *
     * @param text1 the text 1
     * @param text2 the text 2
     * @return the int
     */
    public int longestCommonSubsequenceOptimized(String text1, String text2) {
        int row = text1.length() + 1;
        int column = text2.length() + 1;
        int[] prevRow = new int[column];
        int[] currentRow = new int[column];

        for (int i = 1; i < row; i++) {
            char testChar = text1.charAt(i - 1);
            for (int j = 1; j < column; j++) {
                if (testChar == text2.charAt(j - 1)) {
                    currentRow[j] = prevRow[j - 1] + 1;
                } else {
                    currentRow[j] = Math.max(currentRow[j - 1], prevRow[j]);
                }
            }
            // Swap the arrays for the next iteration
            int[] temp = prevRow;
            prevRow = currentRow;
            currentRow = temp;
        }
        return prevRow[column - 1];
    }
}
