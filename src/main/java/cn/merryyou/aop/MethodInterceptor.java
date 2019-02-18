package cn.merryyou.aop;

/**
 * 方法拦截器
 */
public interface MethodInterceptor {

    Object invoke(MethodInvocation invocation) throws Throwable;
}
