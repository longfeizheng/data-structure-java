package cn.merryyou.thread;

/**
 * Created on 2019/3/3.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
public class TestThreadForNum {
    public static void main(String[] args) {
        new ThreadForNum1().start();
        new ThreadForNum2().start();
    }
}
