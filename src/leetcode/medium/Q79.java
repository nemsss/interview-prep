package leetcode.medium;

/**
 * Created by cenumah on 2019-11-28
 */
public class Q79 {

    public static void main(String[] args) {
//        System.out.println(new Q79().exist(new char[][]{{'A','B','C','E'},
//                        {'S','F','C','S'},{'A','D','E','E'}},
//                "ABCCED"));
//
//        System.out.println(new Q79().exist(new char[][]{{'A','B'}, {'C','D'}},
//                "ABCCED"));

        System.out.println(new Q79().exist(new char[][]{{'A','B'}, {'C','D'}},
                "CDBA"));

        System.out.println(new Q79().exist(new char[][]{"aaaa".toCharArray(),
                        "aaaa".toCharArray(), "aaaa".toCharArray()},
                "aaaaaaaaaaaaa"));


    }

    public boolean exist(char[][] board, String word) {

        if(board == null || board.length == 0) {
            return false;
        }

        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(exist(board, word, i, j, 0, visited)){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean[][] visitedFlags(int row, int col) {
        return new boolean[row][col];
    }

    //ex=position to exclude where U=UP, D=DOWN, L=LEFT, R=RIGHT
    private boolean exist(char[][] board, String word, int i, int j, int currIdx, boolean[][] visited) {

        if(currIdx == word.length()) {
            return true;
        }

        if(i<0 || i>=board.length || j<0 || j>=board[i].length || visited[i][j]) {
            return false;
        }

        if(board[i][j] != word.charAt(currIdx)) {
            return false;
        }

        visited[i][j] = true;
        boolean found = exist(board, word, i, j+1, currIdx+1, visited);
        if(!found)
            found = exist(board, word, i, j-1, currIdx+1, visited);
        if(!found)
            found = exist(board, word, i+1, j, currIdx+1, visited);
        if(!found)
            found = exist(board, word, i-1, j, currIdx+1, visited);

        visited[i][j] = false;
        return found;
    }
}
