package com.xiaor.stage3.network_.udp_;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UdpReceiverA {
    public static void main(String[] args) throws IOException {

        // 1. 构建一个DatagramSocket对象, 准备在9999接收数据
        DatagramSocket socket = new DatagramSocket(9999);

        // 2. 构建一个DatagramPacket对象, 用于接收数据. udp协议,一个数据包最大64k
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);

        // 3. 调用DatagramSocket对象的receive方法,接收数据,将接收到的DatagramPacket对象填充到datagramPacket对象中
        System.out.println("A端等待接收数据...");
        // 如果没有数据包发送到的本机的9999端口,就会阻塞等待
        socket.receive(datagramPacket);

        // 4. 把datagramPacket拆包,取出数据并显示
        int length = datagramPacket.getLength();    // 实际接收到的数据字节长度
        byte[] data = datagramPacket.getData();
        String s = new String(data, 0, length);
        System.out.println("A端接收数据为: " + s);

        // 5. 回复信息
        String info = "好, 明儿见~";
        bytes = info.getBytes();

        DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("192.168.43.134"), 9998);
        socket.send(packet);

        // 6. 释放资源
        socket.close();
        System.out.println("UdpReceiverA 回复信息完毕!");
    }
}
