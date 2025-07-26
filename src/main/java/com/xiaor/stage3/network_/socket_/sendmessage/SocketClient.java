package com.xiaor.stage3.network_.socket_.sendmessage;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class SocketClient {
    public static void main(String[] args) throws IOException {

        // 1. 创建Socket客户端, 并连接本机的9999端口
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端 socket返回=" + socket.getClass());

        // 2. 连接上后,生成socket, 通过socket.getOutputStream()得到和socket对象关联的输出流
        OutputStream outputStream = socket.getOutputStream();

//        // 3. 通过输出流, 发数据给服务器. [输出的是字节流]
//        outputStream.write("hello, server".getBytes());
//        socket.shutdownOutput();        // 设置结束标记, 不然服务器不知道客户端是否发送完毕,会一直等待,无法进行后续工作

//        // 4. 通过输入流,读取从服务器返回回来的数据  [结束的是字节流]
//        InputStream inputStream = socket.getInputStream();
//        byte[] buf = new byte[1024];
//        int readLen = 0;
//        while ((readLen = inputStream.read(buf)) != -1) {
//            System.out.println(new String(buf, 0, readLen));
//        }


        // 3. 传输字符流
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello, server");
        bufferedWriter.newLine();       // 插入换行符,表示写入内容结束, 要求对方使用 readLine()方法, 以此来判断接收完毕
        bufferedWriter.flush();     // 字符流: 务必手动刷新,不然无法写入数据通道

        // 4. IO读取,使用字符流, 使用InputStreamReader将inputStream转换为字符流
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);

//        // 5. 关闭流对象和socket, 必须关闭  [字节流关闭方式]
//        outputStream.close();
//        inputStream.close();

        // 5. 关闭流   [使用字符流时, 需要关闭外层流]
        bufferedReader.close();
        bufferedWriter.close();

        socket.close();
        System.out.println("客户端退出...");
    }
}
