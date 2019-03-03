package cn.merryyou.thread;

/**
 * Created on 2019/3/3.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
public class ThreadForNum2 extends Thread{
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            synchronized (ThreadForNumLock.o){
                System.out.println(2);
                ThreadForNumLock.o.notify();
                try {
                    ThreadForNumLock.o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
