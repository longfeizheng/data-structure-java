package cn.merryyou.aop;

public class TransactionManager {
    public void start() {
        System.out.println("start tx");
    }

    public void commit() {
        System.out.println("commit tx");
    }

    public void rollback() {
        System.out.println("rollback tx");
    }

}
