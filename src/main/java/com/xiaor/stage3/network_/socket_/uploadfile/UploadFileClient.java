package com.xiaor.stage3.network_.socket_.uploadfile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class UploadFileClient {
    public static void main(String[] args) throws IOException {
        // 1. 创建Socket对象, 指定服务器的IP地址和端口号
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        System.out.println("客户端 socket返回=" + socket.getClass());

        // 2. 创建读取磁盘文件的输入流
        String filePath = "D:\\xiaoR\\file_temp\\java_overview\\resource\\picture\\radar.png";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));

        // 3. 从输入流中获取字节数组
        byte[] bytes = StreamUtils.streamToBytes(bis);

        // 4. 从socket中获取输出流, 将bytes数据写入到数据通道
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes);
        bis.close();
        socket.shutdownOutput();    // 设置写入数据的结束标记

        // 5. 关闭流和socket
        bos.close();
        socket.close();
    }
}
