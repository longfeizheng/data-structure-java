package cn.merryyou.linklist;

/**
 * Created on 2018/6/21.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
public class LinkedList<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e ,Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e,null);
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString() {
            return e.toString();
        }


    }



    private Node head;
    private int size;

    public LinkedList(){
        head = null;
        size = 0;
    }

    /**
     * 判断链表中的元素个数
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 返回链表是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    public void addFirst(E e){
        head = new Node(e,head);
        size++;
    }

    public void add(int index,E e){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");

        if(index ==0){
            addFirst(e);
        }else {
            Node prev =head;


        }
    }
}
