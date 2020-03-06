package educative.arrays;

/**
 * Created by cenumah on 2019-12-15
 */
public class FindSmallestCommonNumber {

    public static void main(String[] args) {

        int[] a = new int[]{0, 3, 4, 9};
        int[] b = new int[]{1, 2, 4, 9};
        int[] c = new int[]{0, 4, 5};

        System.out.println(find_least_common_number(a, b, c));
    }

    static Integer find_least_common_number(int[] a1, int[] a2, int[] a3) {

        int i = 0, j = 0, k = 0;

        while(i < a1.length && j < a2.length && k < a3.length) {
            if(a1[i] == a2[j] && a2[j] == a3[k]){
                return a1[i];
            }

            if(a2[j] >= a1[i] && a3[k]>= a1[i]) {
                i++;
                continue;
            }

            if(a2[j] < a1[i]){
                j++;
            }

            if(a3[k] < a1[i]){
                k++;
            }
        }

        return null; // Replace with actual smallest common value
    }
}
