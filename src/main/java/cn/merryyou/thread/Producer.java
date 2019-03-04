package cn.merryyou.thread;

/**
 * Created on 2019/3/3.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
public class Producer extends Thread {

    @Override
    public void run() {
        while (true) {
            synchronized (Container.container) {
                // 1. 容器满则停止
                if (Container.container.size() == 10) {
                    try {
                        Container.container.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 2. 往容器里面放水果
                Container.container.add("apple");
                System.out.println("往容器里面放了一个水果，当前容器中数量为：" + Container.container.size() + "!!!!!!!!!!!!");
                // 3. 唤醒消费者
                Container.container.notify();
            }
            // 4. 模拟控制速度
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
