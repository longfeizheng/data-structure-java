package cn.merryyou.thread;

/**
 * Created on 2019/3/3.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
public class SaleWindowTest {
    public static void main(String[] args) {
        SaleWindow saleWindow = new SaleWindow();

        Thread t1 = new Thread(saleWindow);
        Thread t2 = new Thread(saleWindow);

        t1.setName("A窗口");
        t2.setName("B窗口");

        t1.start();
        t2.start();
    }
}
