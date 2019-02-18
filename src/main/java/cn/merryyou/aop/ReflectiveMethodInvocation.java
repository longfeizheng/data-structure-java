package cn.merryyou.aop;

import java.lang.reflect.Method;
import java.util.List;

public class ReflectiveMethodInvocation implements MethodInvocation {

    private final Object targetObject;

    private final Method targetMethod;

    private final List<MethodInterceptor> interceptorList;

    private int currentInterceptorIndex = -1;

    public ReflectiveMethodInvocation(Object targetObject, Method targetMethod, List<MethodInterceptor> interceptorList) {
        this.targetObject = targetObject;
        this.targetMethod = targetMethod;
        this.interceptorList = interceptorList;
    }

    @Override
    public Object proceed() throws Throwable {

        if (this.currentInterceptorIndex == this.interceptorList.size() - 1) {
            return invokeJoinPoint();
        }

        this.currentInterceptorIndex++;

        MethodInterceptor interceptor =
                this.interceptorList.get(this.currentInterceptorIndex);
        return interceptor.invoke(this);
    }

    private Object invokeJoinPoint() throws Throwable {

        return this.targetMethod.invoke(this.targetObject);
    }
}
