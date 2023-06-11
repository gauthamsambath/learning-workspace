package DSAProblems;

public class LongestPallindromicSubstring {
    public static void main(String[] args) {
        long timeAtStartingMillis = System.currentTimeMillis();
        long timeAtStartingNano = System.nanoTime();
        String testString = "mqizdjrfqtmcsruvvlh";
        LongestPallindromicSubstring longestPallindromicSubstring = new LongestPallindromicSubstring();
        System.out.println("longest pallindrome = "+longestPallindromicSubstring.longestPalindrome(testString));
        long timeAtEndingMillis = System.currentTimeMillis();
        long timeAtEndingNano = System.nanoTime();
        System.out.println("Time taken to run the program in milli seconds = " + (timeAtEndingMillis - timeAtStartingMillis));
        System.out.println("Time taken to run the program in nano seconds = " + (timeAtEndingNano - timeAtStartingNano));
    }

    public String longestPalindrome(String s) {
        int lengthOfString = s.length();
        int[][] dp = new int[lengthOfString][lengthOfString];

        int max = 1;
        int left = 0;
        int right = 0;


        for (int i = 0; i < lengthOfString; i++) {
            dp[i][i] = 1;


            if (i + 1 < lengthOfString && s.substring(i, i + 1).equals(s.substring(i + 1, i + 2))) {
                // System.out.println(s.substring(i,i+1)+" "+s.substring(i+1,i+2));
                dp[i][i + 1] = 1;
                if (lengthOfString > 1) {
                    if (max < 2) {
                        left = i;
                        right = i + 1;
                    }
                }

            }
        }
        if (lengthOfString > 2) {
            for (int i = 2; i < lengthOfString; i++) {
                for (int j = 0; j < lengthOfString; j++) {
                    // System.out.println("j = "+j+"i = "+i);
                    if ((j + i) < lengthOfString && s.substring(j, j + 1).equals(s.substring(i + j, i + j + 1))) {
                        if (dp[j + 1][j + i - 1] == 1) {
                            dp[j][j + i] = 1;
                            if (max < i + 1) {
                                left = j;
                                right = j + i;
                            }
                        }
                    }
                }
            }

        }


        // System.out.println(Arrays.deepToString(dp));

        return s.substring(left, right + 1);
    }
}
