package cn.merryyou.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

//自定义客户端业务处理类
public class NettyClientHandler extends ChannelInboundHandlerAdapter {
    @Override //通道就绪事件
    public void channelActive(ChannelHandlerContext ctx) {
        System.out.println("Client: " + ctx);
        ctx.writeAndFlush(Unpooled.copiedBuffer("老板,还钱吧", CharsetUtil.UTF_8));
    }

    @Override //通道读取数据事件
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf in = (ByteBuf) msg;
        System.out.println("服务器端发来的消息 : " + in.toString(CharsetUtil.UTF_8));
    }

    @Override //数据读取完毕事件
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override //异常发生事件
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        ctx.close();
    }
}