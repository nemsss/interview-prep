package educative.arrays;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by cenumah on 2019-12-14
 */
public class MaxInSlidingWindow {

    public static void main(String[] args) {

        System.out.println(findMaxSlidingWindow(new int[]{-4, 2, -5, 3, 6}, 3));
    }

    public static ArrayDeque<Integer> findMaxSlidingWindow(int[] arr, int size) {

        if(arr.length < size) {
            return new ArrayDeque<>();
        }

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));

        int start = 0;

        for(int i=0; i<arr.length; i++) {
            if(i < size-1) {
                heap.add(arr[i]);
                continue;
            }

            heap.add(arr[i]);
            deque.add(heap.peek());
            heap.remove(arr[start]);
        }

        return deque;
    }

}
