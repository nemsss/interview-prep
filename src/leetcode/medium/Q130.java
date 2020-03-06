package leetcode.medium;

import java.util.Arrays;

/**
 * Created by cenumah on 2019-11-30
 */
public class Q130 {
    public static void main(String[] args) {
        char[][] input = new char[][]{"OOO".toCharArray(), "OOO".toCharArray(), "OOO".toCharArray()};
//        new Q130().solve(input);
//        System.out.println(Arrays.deepToString(input));

        input = new char[][]{"XXX".toCharArray(), "XOX".toCharArray(), "XXX".toCharArray()};
//        new Q130().solve(input);
//        System.out.println(Arrays.deepToString(input));

        input = new char[][]{"OXXOX".toCharArray(), "XOOXO".toCharArray(), "XOXOX".toCharArray(),
                            "OXOOO".toCharArray(), "XXOXO".toCharArray()};
        new Q130().solve(input);
        System.out.println(Arrays.deepToString(input));

    }

    public void solve(char[][] board) {
        if(board == null || board.length == 0)
            return;

        boolean[][] visiting = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                if(board[i][j] == 'O') {
                    boolean[] res = new boolean[]{true};
                    attempt(i, j, board, visiting, res);
                }
            }
        }
    }

    //OXXOX     OXXOX
    //XOOXO     XXXXO
    //XOXOX     XXXOX
    //OXOOO     OXOOO
    //XXOXO     XXOXO

    private void attempt(int i, int j, char[][] board, boolean[][] visiting, boolean[] res) {
        if(i<0 || i>=board.length || j<0 || j>=board[i].length) {
            res[0] = false;
            return;
        }

        if(board[i][j] == 'X' || visiting[i][j]){
            res[0] = true;
            return;
        }

        if(i==0 || i==board.length-1 || j==0 || j==board[i].length-1) {
            res[0] = false;
            return;
        }

        //0 0 0
        //0 0 0
        //0 0 0

        visiting[i][j] = true;
        attempt(i+1, j, board, visiting, res);
        boolean flip= res[0];
        attempt(i-1, j, board, visiting, res);
        flip|= res[0];
        attempt(i, j+1, board, visiting, res);
        flip|= res[0];
        attempt(i, j-1, board, visiting, res);
        flip|= res[0];
        if(flip){
            board[i][j] = 'X';
        }

        res[0] = flip;
        visiting[i][j] = false;
    }

}
