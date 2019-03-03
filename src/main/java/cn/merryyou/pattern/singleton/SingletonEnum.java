package cn.merryyou.pattern.singleton;

/**
 * Created on 2019/3/2.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
public enum SingletonEnum {
    INSTANCE;

    int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
