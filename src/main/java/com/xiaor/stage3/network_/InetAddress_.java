package com.xiaor.stage3.network_;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddress_ {
    public static void main(String[] args) {
        // 获取本机的InetAddress对象
        InetAddress localHost = null;
        try {
            localHost = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        System.out.println(localHost);

        // 根据域名获取InetAddress对象
        InetAddress baidu = null;
        try {
            baidu = InetAddress.getByName("www.baidu.com");
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        System.out.println(baidu);

        // 通过InetAddress对象,获取对应的地址
        String hostAddress = baidu.getHostAddress();
        System.out.println(hostAddress);
    }
}
