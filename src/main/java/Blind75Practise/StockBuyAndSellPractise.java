package Blind75Practise;

/**
 * The type Stock buy and sell practise.
 */
public class StockBuyAndSellPractise {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int[] stockArray = {7,6,4,3,1};
        StockBuyAndSellPractise stockBuyAndSellPractise = new StockBuyAndSellPractise();
        System.out.println("Max profit attainable is = " + stockBuyAndSellPractise.maxProfit(stockArray));

    }

    /**
     * Max profit int.
     *
     * @param prices the prices
     * @return the int
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int j = 1, i = 0; j < prices.length; j++) {
            if (prices[j] - prices[i] > 0) {
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            } else {
                i = j;
            }
        }
        return maxProfit;
    }
}
