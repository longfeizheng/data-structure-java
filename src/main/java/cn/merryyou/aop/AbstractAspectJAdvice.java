package cn.merryyou.aop;

import java.lang.reflect.Method;

public abstract class AbstractAspectJAdvice implements MethodInterceptor{

    private Method adviceMethod;

    private Object adviceObject;

    public AbstractAspectJAdvice(Method adviceMethod, Object adviceObject) {
        this.adviceMethod = adviceMethod;
        this.adviceObject = adviceObject;
    }

    public Method getAdviceMethod() {
        return this.adviceMethod;
    }

    public void invokeAdviceMethod() throws Throwable {
        adviceMethod.invoke(adviceObject);
    }
}
