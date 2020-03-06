package leetcode.easy;

/**
 * Created by cenumah on 2019-11-22
 */
public class Q92 {

    public static void main(String[] args) {

        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
    }

    public static int maxProfit(int[] prices) {
        int total = 0;
        int bench = 0;
        int buy = 0;
        int sell = 0;

        for(int i=1; i<prices.length; i++) {

            if(prices[i] - prices[buy] > bench) {
                bench = prices[i]-prices[buy];
                sell = i;
                continue;
            }

            if(prices[i] < prices[sell]){
                total += prices[sell] - prices[buy];
                bench = 0;
                buy = i;
                sell = i;
            }
        }

        return total + bench;
    }
}
