package com.xiaor.stage3.network_.socket_.uploadfile;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadFileServer {
    public static void main(String[] args) throws IOException {
        // 1. 创建ServerSocket对象, 监听8888端口
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务器启动,监听8888端口...");

        // 2. 等待客户端连接
        Socket socket = serverSocket.accept();

        // 3. 读取客户端发送的数据
        byte[] bytes = StreamUtils.streamToBytes(socket.getInputStream());

        // 4. 将得到的bytes数组,写入到指定的路径,就得到一个文件了
        String destPath = "D:\\xiaoR\\file_temp\\java_overview\\dest\\picture\\radar.png";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destPath));
        bos.write(bytes);
        bos.close();

        // 关闭其他资源
        socket.close();
        serverSocket.close();
    }
}
