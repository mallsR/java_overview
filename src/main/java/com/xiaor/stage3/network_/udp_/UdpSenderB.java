package com.xiaor.stage3.network_.udp_;

import java.io.IOException;
import java.net.*;

public class UdpSenderB {

    public static void main(String[] args) throws IOException {
        // 1. 创建DatagramSocket对象, 准备在9998端口接收数据
        DatagramSocket socket = new DatagramSocket(9998);

        // 2. 将需要发送的数据封装成DatagramPacket对象
        String info = "走, 明儿吃火锅~";
        byte[] bytes = info.getBytes();

        DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("192.168.43.134"), 9999);
        socket.send(packet);

        // 3. 释放资源
        socket.close();
        System.out.println("UdpSenderB 发送数据完毕!");
    }
}
