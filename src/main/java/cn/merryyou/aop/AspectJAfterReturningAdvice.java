package cn.merryyou.aop;

import java.lang.reflect.Method;

public class AspectJAfterReturningAdvice extends AbstractAspectJAdvice {

    public AspectJAfterReturningAdvice(Method method, Object adviceObject) {
        super(method, adviceObject);
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable{
        Object o = invocation.proceed();
        this.invokeAdviceMethod();
        return o;
    }
}
