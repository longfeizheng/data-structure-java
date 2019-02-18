package cn.merryyou.aop;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ReflectiveMethodInvocationTest {

    private AspectJBeforeAdvice beforeAdvice = null;

    private AspectJAfterReturningAdvice afterReturningAdvice = null;

    private NioCoderService nioCoderService;

    private TransactionManager tx;

    @Before
    public void setUp() throws Exception {
        nioCoderService = new NioCoderService();
        tx = new TransactionManager();
        beforeAdvice = new AspectJBeforeAdvice(TransactionManager.class.getMethod("start"), tx);
        afterReturningAdvice = new AspectJAfterReturningAdvice(TransactionManager.class.getMethod("commit"), tx);
    }

    @Test
    public void testMethodInvocation() throws Throwable {
        Method method = NioCoderService.class.getMethod("testAop");
        List<MethodInterceptor> interceptorList = new ArrayList<>();
        interceptorList.add(afterReturningAdvice);
        interceptorList.add(beforeAdvice);

        ReflectiveMethodInvocation mi = new ReflectiveMethodInvocation(nioCoderService, method, interceptorList);

        mi.proceed();
    }
}
