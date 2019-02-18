package cn.merryyou.aop;

public interface MethodInterceptor {

    Object invoke(MethodInvocation invocation) throws Throwable;
}
