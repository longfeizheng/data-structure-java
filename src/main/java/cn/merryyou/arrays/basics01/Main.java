package cn.merryyou.arrays.basics01;

/**
 * 简单定义数组
 * Created on 2018/6/21.
 *
 * @author zlf
 * @since 1.0
 */
public class Main {

    public static void main(String[] args) {

        int[] arr = new int[10];
        for(int i=0;i<arr.length;i++){
            arr[i] = i;
        }
        print(arr);

        int[] scores = new int[]{100,99,66};
        print(scores);

        scores[0] = 96;

        print(scores);
    }

    private static void print(int[] arr) {
        for (int i: arr){
            System.out.print(i+", ");
        }
        System.out.println();
    }
}
