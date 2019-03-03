package cn.merryyou.pattern.singleton;

/**
 * Created on 2019/3/2.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
public class Singleton1 {

    private static final Singleton1 instance = null;

    private Singleton1() {
    }

    ;

    public static Singleton1 getInstance() {
        if (instance == null) {
            return new Singleton1();
        }
        return instance;
    }
}
