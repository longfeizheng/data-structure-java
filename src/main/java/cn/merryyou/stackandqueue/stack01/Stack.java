package cn.merryyou.stackandqueue.stack01;

/**
 * Created on 2018/6/21.
 *
 * @author zlf
 * @since 1.0
 */
public interface Stack<E> {

    int getSize();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();
}
