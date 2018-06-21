package cn.merryyou.arrays.ownarray02;

/**
 * Created on 2018/6/21.
 *
 * @author zlf
 * @since 1.0
 */
public class Array {

    private int[] data;

    private int size;

    /**
     * 构造函数，传入数据的容量capacity构造array
     *
     * @param capacity
     */
    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    /**
     * 无惨构造函数，默认数据的容量capacity=10
     */
    public Array() {
        this(10);
    }

    /**
     * 获取数据容量
     *
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 获取数组中的元素
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断数据是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(int e) {
        add(0, e);
    }

    public void addLast(int e) {
        add(size, e);
    }

    /**
     * 向index索引的位置插入一个新的元素
     *
     * @param index
     * @param e
     */
    public void add(int index, int e) {
        if (size == data.length) {
            throw new IllegalArgumentException("Add failed. Array is full.");
        }

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = e;

        size++;
    }

    /**
     * 获取index索引位置的元素
     *
     * @param index
     * @return
     */
    public int get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal.");

        return data[index];
    }

    /**
     * 修改index索引位置的元素为e
     *
     * @param index
     * @param e
     */
    public void set(int index, int e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal.");

        data[index] = e;
    }

    /**
     * 查找数组中是否存在元素e
     *
     * @param e
     * @return
     */
    public boolean contains(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中元素所在的索引，如果不存在元素e,则返回-1
     *
     * @param e
     * @return
     */
    public int find(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e)
                return i;
        }
        return -1;
    }

    /**
     * 从数组中删除index位置的元素，返回删除的元素
     *
     * @param index
     * @return
     */
    public int remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        int ret = data[index];

        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        return ret;
    }

    /**
     * 删除第一个元素
     *
     * @return
     */
    public int removeFirst() {
        return remove(0);
    }

    /**
     * 删除最后一个元素
     *
     * @return
     */
    public int removeLast() {
        return remove(size - 1);
    }

    /**
     * 从数组中删除元素
     *
     * @return
     */
    public void removeElement(int e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }
}
