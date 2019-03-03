package cn.merryyou.thread;

/**
 * Created on 2019/3/3.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
public class SaleWindow implements Runnable {

    private int id = 10;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (this) {
                if (id > 0) {
                    System.out.println(Thread.currentThread().getName() + "卖了编号为" + id + "的火车票");
                    id--;
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
