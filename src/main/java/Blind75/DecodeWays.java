package Blind75;

public class DecodeWays {

    public static void main(String[] args) {
        String codeToDecode = "11106";
        DecodeWays decodeWays = new DecodeWays();
        System.out.println("Number of ways the code " + codeToDecode + " can be decoded is = " + decodeWays.numDecodings(codeToDecode));
    }

    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[1] = Integer.parseInt(s.substring(0, 1)) >= 1 ? 1 : 0;
        dp[0] = dp[1];
        for (int i = 2; i <= s.length(); i++) {
            int decodeWays = 0;
            int singleNumber = Integer.parseInt(s.substring(i - 1, i));
            int doubleNumber = Integer.parseInt(s.substring(i - 2, i));
            if (codeBetweenTheAlphabets(singleNumber))
                decodeWays += dp[i - 1];
            if (doubleNumber >= 10 && codeBetweenTheAlphabets(doubleNumber))
                decodeWays += dp[i - 2];
            dp[i] = decodeWays;
        }
        return dp[s.length()];
    }

    private boolean codeBetweenTheAlphabets(int number) {
        return number >= 1 && number <= 26;
    }
}
