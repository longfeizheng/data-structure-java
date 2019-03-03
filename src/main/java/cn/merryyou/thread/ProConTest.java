package cn.merryyou.thread;

/**
 * Created on 2019/3/3.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
public class ProConTest {
    public static void main(String[] args) {
        new Consumer().start();
        new Producer().start();
    }
}
