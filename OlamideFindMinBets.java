package others;

/**
 * Created by cenumah on 2020-01-06
 */
public class OlamideFindMinBets {

    public static void main(String[] args) {

        System.out.println(getMinimumNumberOfMoves(0, 8));
        System.out.println(getMinimumNumberOfMoves(2, 18));
        System.out.println(getMinimumNumberOfMoves(10, 10));
        System.out.println(getMinimumNumberOfMoves(2, 10));
        System.out.println(getMinimumNumberOfMoves(21, 1800));
    }

    public static int getMinimumNumberOfMoves(int max, int target) {
        return getMinimumNumberOfMoves(1, max, 0, target);
    }

    public static int getMinimumNumberOfMoves(int current, int remainingCount, int currentMovesNo, int target) {
        if (current == target) {
            return currentMovesNo;
        }
        if (remainingCount == 0 || (((current * 2)) > target) || current == 1 || (current + 1) * 2 == target)
            return getMinimumNumberOfMoves(current + 1, remainingCount, currentMovesNo + 1, target);
        else
            return getMinimumNumberOfMoves(((current * 2)), remainingCount - 1, currentMovesNo + 1, target);
    }
}
