package leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Created by cenumah on 2019-12-23
 */
public class Q253 {

    public static void main(String[] args) {
//
        int[][] intervals = new int[][]{{0,30}, {5,10}, {15,20}};
        System.out.println(new Q253().minMeetingRooms(intervals));

        intervals = new int[][]{{7,10}, {2,4}};
        System.out.println(new Q253().minMeetingRooms(intervals));

        intervals = new int[][]{{5,8}, {6,8}};
        System.out.println(new Q253().minMeetingRooms(intervals));

        intervals = new int[][]{{6,15}, {13,20}, {6,17}};
        System.out.println(new Q253().minMeetingRooms(intervals));

        intervals = new int[][]{{9,10}, {4,9}, {4,17}};
        System.out.println(new Q253().minMeetingRooms(intervals));

        intervals = new int[][]{{2,15}, {36,45}, {9,29}, {16,23}, {4,9}};
        System.out.println(new Q253().minMeetingRooms(intervals));
    }

    public int minMeetingRooms(int[][] intervals) {

        PriorityQueue<int[]> rooms = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int res = 0;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        for(int[] m : intervals){
            if(rooms.isEmpty()) {
                rooms.add(m);
                res++;
            }
            else if(m[0] < rooms.peek()[1] && m[0] >= rooms.peek()[0]) {
                rooms.add(m);
                res++;
            } else {
                rooms.remove();
                rooms.add(m);
            }
        }

        return res;
    }

    public void rotate(int[][] arr) {

        int n = arr.length;
        int spins = n/2;
        int swaps = n -1;

        for(int i=0; i<spins; i++) {

            for(int j=i; j<swaps-i; j++) {

                int tmp = arr[i][j];

                arr[i][j] = arr[swaps-j][i];

                arr[swaps-j][i] = arr[swaps-i][swaps-j];

                arr[swaps-i][swaps-j] = arr[j][swaps-i];

                arr[j][swaps-i] = tmp;
            }
        }
    }
}


