package cn.merryyou.rpc.server;

import cn.merryyou.rpc.ClassInfo;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.reflections.Reflections;

import java.lang.reflect.Method;
import java.util.Set;

public class InvokeHandler extends ChannelInboundHandlerAdapter {

    /**
     * 得到接口下某个实现类的名字
     *
     * @param classInfo
     * @return
     * @throws Exception
     */
    private String getInplClassName(ClassInfo classInfo) throws Exception {
        String interfacePath = "cn.merryyou.rpc.server";
        int lastDot = classInfo.getClassName().lastIndexOf(".");
        String interfaceName = classInfo.getClassName().substring(lastDot);
        Class<?> superClass = Class.forName(interfacePath + interfaceName);
        Reflections reflections = new Reflections(interfacePath);
        //接口下的所有实现类
        Set<Class<?>> implClassSet = (Set<Class<?>>) reflections.getSubTypesOf(superClass);
        if (implClassSet.size() == 0) {
            System.out.println("未找到实现类");
            return null;
        } else if (implClassSet.size() > 1) {
            System.out.println("找到多个实现类，未明确使用哪一个");
            return null;
        } else {
            // 集合转换为数组
            Class[] classes = implClassSet.toArray(new Class[0]);
            return classes[0].getName();
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ClassInfo classInfo = (ClassInfo) msg;
        Object clazz = Class.forName(getInplClassName(classInfo)).newInstance();
        Method method = clazz.getClass().getMethod(classInfo.getMethodName(), classInfo.getTypes());
        // 反射调用
        Object retuslt = method.invoke(clazz, classInfo.getArgs());
        ctx.writeAndFlush(retuslt);
    }
}
