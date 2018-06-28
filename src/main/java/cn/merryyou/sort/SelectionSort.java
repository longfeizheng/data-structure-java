package cn.merryyou.sort;

/**
 * Created on 2018/6/20.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {10,9,8,7,6,5,4,3,2,1};
//        sort(arr);
        bubble(arr);
//         for(int i: arr){
//             System.out.print(i+" ");
//         }

        System.out.println('0'+10%10);
    }


    public static void sort(int[] arr){

        int n = arr.length;
        for( int i = 0 ; i < n ; i ++ ){
            // 寻找[i, n)区间里的最小值的索引
            int minIndex = i;
            for( int j = i + 1 ; j < n ; j ++ )
                if( arr[j] < arr[minIndex] )
                    minIndex = j;

            swap( arr , i , minIndex);
        }
    }

    public static void bubble(int[] arr){
        int n= arr.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    swap(arr,j ,j+1);
                }
            }
        }
    }


    private static void swap(int[] arr ,int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void intToString(int num){

    }
}
