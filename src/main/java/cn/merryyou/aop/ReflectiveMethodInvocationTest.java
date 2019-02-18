package cn.merryyou.aop;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ReflectiveMethodInvocationTest {

    private AspectJBeforeAdvice beforeAdvice = null;

    private AspectJAfterReturningAdvice afterReturningAdvice = null;

    private NioCoderService nioCoderService;

    private TransactionManager tx;

    public void setUp() throws Exception {
        nioCoderService = new NioCoderService();
        tx = new TransactionManager();
        beforeAdvice = new AspectJBeforeAdvice(TransactionManager.class.getMethod("start"), tx);
        afterReturningAdvice = new AspectJAfterReturningAdvice(TransactionManager.class.getMethod("commit"), tx);
    }

    public void testMethodInvocation() throws Throwable {
        Method method = NioCoderService.class.getMethod("testAop");
        List<MethodInterceptor> interceptorList = new ArrayList<>();
        interceptorList.add(beforeAdvice);
        interceptorList.add(afterReturningAdvice);

        ReflectiveMethodInvocation mi = new ReflectiveMethodInvocation(nioCoderService, method, interceptorList);

        mi.proceed();
    }


    public static void main(String[] args) throws Throwable {
        ReflectiveMethodInvocationTest reflectiveMethodInvocationTest = new ReflectiveMethodInvocationTest();
        reflectiveMethodInvocationTest.setUp();
        reflectiveMethodInvocationTest.testMethodInvocation();
    }
}
