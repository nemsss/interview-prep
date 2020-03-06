package educative.arrays;

/**
 * Created by cenumah on 2019-12-15
 */
public class MaxSingleSellProfit {

    public static void main(String[] args) {

        System.out.println(find_buy_sell_stock_prices(new int[]{8,5,12,9,19,1}));
        System.out.println(find_buy_sell_stock_prices(new int[]{21,12,11,9,6,3}));
    }

    public static Tuple find_buy_sell_stock_prices(int[] arr) {
        //TODO: Write - Your - Code

        if(arr == null || arr.length < 2) {
            return null;
        }

        int buy = arr[0];
        int current_buy = arr[0];
        int sell = arr[1];
        int max = sell - buy;

        for(int i=1; i<arr.length; i++) {

            int price = arr[i];

            if(price - current_buy > max) {
                buy = current_buy;
                sell = price;
                max = sell - buy;
                continue;
            }

            if(price < current_buy) {
                current_buy = price;
            }
        }

        return new Tuple<>(buy, sell);
    }

    static class Tuple<X, Y> {
        X x;
        Y y;

        public Tuple(X x, Y y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return String.format("x-> %s, y-> %s", x, y);
        }
    }
}
