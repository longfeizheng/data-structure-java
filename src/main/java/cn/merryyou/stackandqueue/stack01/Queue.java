package cn.merryyou.stackandqueue.stack01;

/**
 * Created on 2018/6/21.
 *
 * @author zlf
 * @since 1.0
 */
public interface Queue<E> {

    int getSize();

    boolean isEmpty();

    void enqueue(E e);

    E dequeue();

    E getFront();
}
