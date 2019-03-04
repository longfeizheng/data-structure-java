package cn.merryyou.thread;

/**
 * Created on 2019/3/3.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
public class Consumer extends Thread {
    @Override
    public void run() {
        while (true) {
            synchronized (Container.container) {
                // 1. 如果容器中没有水果，等待
                if (Container.container.size() == 0) {
                    try {
                        Container.container.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 2. 从容器里面取水果
                Container.container.remove("apple");
                System.out.println("从容器里面放水果，当前容器中水量为：" + Container.container.size());
                // 3. 唤醒生产者
                Container.container.notify();
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
