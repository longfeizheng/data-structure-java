package cn.merryyou.leetcode;

/**
 * 数组中指定反转
 * Created on 2019/3/2.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
public class ListReverse {

    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 3, 4, 5};
        reserse(arr, 1, 3);
        for (int i : arr) {
            System.out.print(i + ",");
        }
    }


    /**
     * 1 2 3 4 5
     * 1 4 3 2 5
     *
     * @param arr
     * @param begin
     * @param end
     * @return
     */
    public static int[] reserse(int[] arr, int begin, int end) {
        if (null == arr || arr.length == 0) {
            return null;
        }
        if (begin < 0 || begin > end || end > arr.length) {
            return null;
        }
        int i = begin;
        int j = end;
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
