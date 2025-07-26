package com.xiaor.stage3.network_.socket_.sendmessage;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(9999);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("服务器监听9999端口,等待连接...");

        // 如果有客户端连接时,服务器才会返回Socket对象, 否则阻塞
        // serverSocket可以通过accept()方法返回多个Socket对象[多个客户端连接服务器的并发]
        Socket socket = serverSocket.accept();
        System.out.println("socket: " + socket.getClass());

        // 获取socket的输入流
        InputStream inputStream = socket.getInputStream();

//        // 通过输入流接收数据  [接收的是字节流]
//        byte[] bytes = new byte[1024];
//        int readLen = 0;
//        while ((readLen = inputStream.read(bytes)) != -1) {
//            System.out.println(new String(bytes, 0, readLen));      // 根据读取到的实际长度,显示内容
//        }

//        // 通过输出流,向客户端回应数据  [输出的是字节流]
//        OutputStream outputStream = socket.getOutputStream();
//        outputStream.write("hello, client".getBytes());
//        socket.shutdownOutput();    // 设置结束标记


        // IO读取,使用字符流, 使用InputStreamReader将inputStream转换为字符流
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);

        // IO写入,使用字符流, 使用OutputStreamWriter将outputStream转换为字符流
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello, client");
        bufferedWriter.newLine();
        bufferedWriter.flush();

//        // 关闭流和socket
//        inputStream.close();
//        outputStream.close();

        // 使用字符流时,需要关闭外层流
        bufferedWriter.close();
        bufferedReader.close();

        socket.close();
        serverSocket.close();
    }
}
