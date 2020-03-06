package leetcode.easy;

import java.util.Arrays;

/**
 * Created by cenumah on 2019-11-28
 */
public class Q733 {

    public static void main(String[] args) {

        int[][] img = new int[][]{{0,0,0}, {0,1,1}};
        System.out.println(Arrays.deepToString(new Q733().floodFill(img, 1, 1, 1)));
    }

    /*
    An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).

    Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

    To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.

    At the end, return the modified image.
     */

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        if(image == null || image.length == 0) {
            return image;
        }

        boolean[][] visited = new boolean[image.length][image[0].length];
        floodFill(image, sr, sc, newColor, image[sr][sc], visited);

        return image;
    }

    private void floodFill(int[][] img, int sr, int sc, int newColor, int target, boolean[][] visited) {

        if(sr<0 || sr>=img.length || sc<0 || sc>=img[sr].length) {
            return;
        }

        if(img[sr][sc] != target || visited[sr][sc]) {
            return;
        }

        img[sr][sc] = newColor;
        visited[sr][sc] = true;

        floodFill(img, sr, sc+1, newColor, target, visited);
        floodFill(img, sr, sc-1, newColor, target, visited);
        floodFill(img, sr+1, sc, newColor, target, visited);
        floodFill(img, sr-1, sc, newColor, target, visited);
    }
}
