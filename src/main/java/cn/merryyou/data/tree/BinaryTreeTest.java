package cn.merryyou.data.tree;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Queue;

import static cn.merryyou.data.tree.BinaryTree.*;

/**
 * Created on 2018/4/16.
 *
 * @author zlf
 * @since 1.0
 */
public class BinaryTreeTest {

    @Test
    public void testJunit() {
        System.out.println("test");
    }

    /**
     * 构建树
     */
    @Test
    public void testCreate() {
        BinaryTree node = new BinaryTree("a");
        System.out.println("【testCreate】测试:");
        System.out.println("【node data】:" + node.getData());
        System.out.println("【node left data】:" + (node.left == null ? "null" : node.left.getData()));
        System.out.println("【node right data】:" + (node.right == null ? "null" : node.right.getData()));
    }

    /**
     * 测试插入节点
     */
    @Test
    public void testInsert() {
        System.out.println("【testInsert】测试:");
        BinaryTree node_a = new BinaryTree("a");
        node_a.insertLeft(node_a, "b");
        node_a.insertRight(node_a, "c");

        BinaryTree node_b = node_a.left;
        node_b.insertRight(node_b, "d");

        BinaryTree node_c = node_a.right;
        node_c.insertLeft(node_c, "e");
        node_c.insertRight(node_c, "f");

        BinaryTree node_d = node_b.right;
        BinaryTree node_e = node_c.left;
        BinaryTree node_f = node_c.right;

        System.out.println("【node_a data】:" + node_a.getData());
        System.out.println("【node_b data】:" + node_b.getData());
        System.out.println("【node_c data】:" + node_c.getData());
        System.out.println("【node_d data】:" + node_d.getData());
        System.out.println("【node_e data】:" + node_e.getData());
        System.out.println("【node_f data】:" + node_f.getData());
    }

    @Test
    public void testQueue() {
        System.out.println("【testQueue】测试:");
        Queue<String> queue = new ArrayDeque<String>();
        queue.add("1");
        queue.add("2");
        queue.add("3");

        System.out.print(queue.poll() + " ");
        System.out.print(queue.poll() + " ");
        System.out.print(queue.poll() + " ");
    }

    /**
     * 前序遍历
     */
    @Test
    public void preOrderTest() {
        preOrder(init());
    }

    /**
     * 中序遍历
     */
    @Test
    public void inOrderTest() {
        inOrder(init());
    }

    /**
     * 后序遍历
     */
    @Test
    public void postOrderTest() {
        postOrder(init());
    }

    /**
     * 广度排序
     */
    @Test
    public void bfsOrderTest() {
        bfsOrder(init());
    }

    /**
     * 构造树
     *
     * @return
     */
    @Test
    public BinaryTree init() {
        BinaryTree node_1 = new BinaryTree("1");
        node_1.insertLeft(node_1, "2");
        node_1.insertRight(node_1, "5");

        BinaryTree node_2 = node_1.left;
        BinaryTree node_5 = node_1.right;

        node_2.insertLeft(node_2, "3");
        node_2.insertRight(node_2, "4");

        node_5.insertLeft(node_5, "6");
        node_5.insertRight(node_5, "7");

        return node_1;
    }

    /**
     * 插入树
     */
    @Test
    public BinaryTree searchTree() {
        Integer[] intArr = new Integer[]{50, 76, 21, 4, 32, 100, 64, 52};
        BinaryTree node = new BinaryTree(String.valueOf(50));
        for (int i = 1; i < intArr.length; i++) {
            node.insertNode(node, intArr[i]);
        }

        return node;
    }

    /**
     * 查找是否存在该节点
     */
    @Test
    public void findTreeNode() {
        System.out.println("【findTreeNode】测试:");
        BinaryTree node = new BinaryTreeTest().searchTree();
        System.out.println(node.findNode(node, 52));
    }

    /**
     * 查找最小节点
     */
    @Test
    public void findMinValueTest() {
        System.out.println("【findMinValueTest】测试:");
        BinaryTree node = new BinaryTreeTest().searchTree();
        System.out.println(node.findMinValue(node));
    }

    /**
     * 删除节点
     */
    @Test
    public void removeNodeTest() {
        System.out.println("【removeNodeTest】测试:");
        Integer[] intArr = new Integer[]{50, 30, 70, 20, 40};
        BinaryTree node = new BinaryTree(String.valueOf(50));
        for (int i = 1; i < intArr.length; i++) {
            node.insertNode(node, intArr[i]);
        }
//        System.out.println(node.removeNode(node, 20, null));
//        System.out.println(node.removeNode(node, 20, null));
        System.out.println(node.removeNode(node, 30, null));

        System.out.println("..........");
    }
}
