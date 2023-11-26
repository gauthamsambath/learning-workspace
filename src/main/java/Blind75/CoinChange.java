package Blind75;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Coin change.
 */
public class CoinChange {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int[] denominationArray = {186, 419, 83, 408};
        int targetNumber = 6249;
        CoinChange coinChange = new CoinChange();
        System.out.println("Minimum number coins taken to achieve the target number is = " + coinChange.coinChange(denominationArray, targetNumber));
        System.out.println("Minimum number coins taken to achieve the target number in optimized is = " + coinChange.coinChangeOptimized(denominationArray, targetNumber));
    }

    /**
     * Coin change int.
     *
     * @param coins  the coins
     * @param amount the amount
     * @return the int
     */
    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        Set<Integer> setOfAllCoins = getSetFromDenomination(coins);
        dp[1] = setOfAllCoins.contains(1) ? 1 : 0;
        for (int i = 2; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            boolean enterFlag = false;
            if (setOfAllCoins.contains(i)) {
                dp[i] = 1;
                continue;
            }
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != 0) {
                    enterFlag = true;
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }

            if (!enterFlag)
                dp[i] = 0;
        }
        return dp[amount] == 0 ? -1 : dp[amount];
    }

    /**
     * Gets set from denomination.
     *
     * @param coins the coins
     * @return the set from denomination
     */
    private Set<Integer> getSetFromDenomination(int[] coins) {
        Set<Integer> setOfAllCoins = new HashSet<>();
        for (int i = 0; i < coins.length; i++) {
            setOfAllCoins.add(coins[i]);
        }
        return setOfAllCoins;
    }

    /**
     * Coin change optimized int.
     *
     * @param coins  the coins
     * @param amount the amount
     * @return the int
     */
    public int coinChangeOptimized(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }


}
