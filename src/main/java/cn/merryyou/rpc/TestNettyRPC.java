package cn.merryyou.rpc;

import cn.merryyou.rpc.client.NettyRPCProxy;
import cn.merryyou.rpc.server.HelloNetty;
import cn.merryyou.rpc.server.HelloRPC;

public class TestNettyRPC {
    public static void main(String[] args) {
        //第 1 次远程调用
        HelloNetty helloNetty=(HelloNetty) NettyRPCProxy.create(HelloNetty.class);
        System.out.println(helloNetty.hello());
//第 2 次远程调用
        HelloRPC helloRPC = (HelloRPC) NettyRPCProxy.create(HelloRPC.class);
        System.out.println(helloRPC.hello("RPC"));
    }
}
