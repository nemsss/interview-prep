package educative.arrays;

import java.util.Arrays;

/**
 * Created by cenumah on 2019-12-15
 */
public class QuickSort {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(quick_sort(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(quick_sort(new int[]{1, -9, 3, 2, 5})));
        System.out.println(Arrays.toString(quick_sort(new int[]{0, -9, 0, 2, 5})));
    }

    static int[] quick_sort(int[] arr) {
        //TODO: Write - Your - Code
        if(arr == null || arr.length == 0) {
            return arr;
        }
        sort(arr, 0, arr.length - 1);
        return arr;
    }

    private static void sort(int[] arr, int pivotIdx, int limitIdx) {
        if(pivotIdx < limitIdx) {
            int nextPivotIdx = partition(arr, pivotIdx, limitIdx);
            sort(arr, pivotIdx, nextPivotIdx-1);
            sort(arr, nextPivotIdx+1, limitIdx);
        }
    }

    private static int partition(int[] arr, int pivotIdx, int limitIdx) {
        int i = pivotIdx;
        int j = limitIdx;
        int pivot = arr[pivotIdx];

        while(i < j){
            while(arr[i] <= pivot && i < limitIdx){
                i++;
            }

            while(arr[j] > pivot && j > pivotIdx) {
                j--;
            }

            if(i < j) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }

        arr[pivotIdx] = arr[j];
        arr[j] = pivot;
        return j;
    }


}
