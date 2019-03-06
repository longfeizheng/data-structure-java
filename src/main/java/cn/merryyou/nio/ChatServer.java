package cn.merryyou.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.text.SimpleDateFormat;
import java.util.*;

//聊天程序服务器端
public class ChatServer {
    private ServerSocketChannel listenerChannel; //监听通道  老大
    private Selector selector;//选择器对象  间谍
    private static final int PORT = 9999; //服务器端口

    public ChatServer() {
        try {
            // 1. 得到监听通道  老大
            listenerChannel = ServerSocketChannel.open();
            // 2. 得到选择器  间谍
            selector = Selector.open();
            // 3. 绑定端口
            listenerChannel.bind(new InetSocketAddress(PORT));
            // 4. 设置为非阻塞模式
            listenerChannel.configureBlocking(false);
            // 5. 将选择器绑定到监听通道并监听accept事件
            listenerChannel.register(selector, SelectionKey.OP_ACCEPT);
            printInfo("Chat Server is ready.......");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //6. 干活儿
    public void start() throws  Exception{
        try {
            while (true) { //不停监控
                if (selector.select(2000) == 0) {
                    System.out.println("Server:没有客户端找我， 我就干别的事情");
                    continue;
                }
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    if (key.isAcceptable()) { //连接请求事件
                        SocketChannel sc=listenerChannel.accept();
                        sc.configureBlocking(false);
                        sc.register(selector,SelectionKey.OP_READ);
                        System.out.println(sc.getRemoteAddress().toString().substring(1)+"上线了...");
                    }
                    if (key.isReadable()) { //读取数据事件
                        readMsg(key);
                    }
                    //一定要把当前key删掉，防止重复处理
                    iterator.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //读取客户端发来的消息并广播出去
    public void readMsg(SelectionKey key) throws Exception{
        SocketChannel channel=(SocketChannel) key.channel();
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        int count=channel.read(buffer);
        if(count>0){
            String msg=new String(buffer.array());
            printInfo(msg);
            //发广播
            broadCast(channel,msg);
        }
    }

    //给所有的客户端发广播
    public void broadCast(SocketChannel except,String msg) throws Exception{
        System.out.println("服务器发送了广播...");
        for(SelectionKey key:selector.keys()){
            Channel targetChannel=key.channel();
            if(targetChannel instanceof SocketChannel && targetChannel!=except){
                SocketChannel destChannel=(SocketChannel)targetChannel;
                ByteBuffer buffer=ByteBuffer.wrap(msg.getBytes());
                destChannel.write(buffer);
            }
        }
    }

    private void printInfo(String str) { //往控制台打印消息
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("[" + sdf.format(new Date()) + "] -> " + str);
    }

    public static void main(String[] args) throws Exception {
        new ChatServer().start();;
    }
}
