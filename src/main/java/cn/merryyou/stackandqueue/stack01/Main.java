package cn.merryyou.stackandqueue.stack01;

/**
 * Created on 2018/6/21.
 *
 * @author zlf
 * @since 1.0
 */
public class Main {

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        for(int i=0;i<5;i++){
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}
