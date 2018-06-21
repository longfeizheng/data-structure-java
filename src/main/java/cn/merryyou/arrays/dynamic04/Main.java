package cn.merryyou.arrays.dynamic04;


/**
 * Created on 2018/6/21.
 *
 * @author zlf
 * @since 1.0
 */
public class Main {

    public static void main(String[] args) {
        Array<Integer> arr = new Array<>();
        for (int i=0;i<10;i++){
            arr.addLast(i);
        }

        System.out.println(arr);

        arr.add(1,100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr);

        arr.removeElement(4);
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);
    }
}
