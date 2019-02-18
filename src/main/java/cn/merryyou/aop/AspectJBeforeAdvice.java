package cn.merryyou.aop;

import java.lang.reflect.Method;

public class AspectJBeforeAdvice extends AbstractAspectJAdvice {

    public AspectJBeforeAdvice(Method method, Object adviceObject) {
        super(method, adviceObject);
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable{
        this.invokeAdviceMethod();
        Object o = invocation.proceed();
        return o;
    }
}
