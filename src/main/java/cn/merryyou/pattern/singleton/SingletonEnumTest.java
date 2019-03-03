package cn.merryyou.pattern.singleton;

/**
 * Created on 2019/3/2.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
public class SingletonEnumTest {
    public static void main(String[] args) {
        SingletonEnum singletonEnum = SingletonEnum.INSTANCE;
        singletonEnum.setValue(2);

        SingletonEnum singletonEnum1 = SingletonEnum.INSTANCE;
        System.out.println(singletonEnum1.getValue());
    }
}
