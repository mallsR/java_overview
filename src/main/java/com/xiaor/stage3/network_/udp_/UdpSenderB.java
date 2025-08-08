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
        System.out.println("UdpSenderB 发送数据完毕!");

        // 3. 接收信息
        byte[] bytes1 = new byte[1024];
        DatagramPacket packet1 = new DatagramPacket(bytes1, bytes1.length);

        System.out.println("UdpSenderB 等待接收数据...");
        socket.receive(packet1);

        // 4. 把datagramPacket拆包,取出数据并显示
        int length = packet1.getLength();    // 实际接收到的数据字节长度
        byte[] data = packet1.getData();
        String s = new String(data, 0, length);
        System.out.println("B端接收数据为: " + s);

        // 3. 释放资源
        socket.close();
    }
}
