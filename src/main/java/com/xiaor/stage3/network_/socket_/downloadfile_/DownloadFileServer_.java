package com.xiaor.stage3.network_.socket_.downloadfile_;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

@Slf4j
public class DownloadFileServer_ {
    public static void main(String[] args) throws IOException {

        // 1.构建服务器,监听9999端口
        ServerSocket server = new ServerSocket(9999);
        log.info("服务器启动,等待连接...");

        // 2.等待客户端连接
        Socket socket = server.accept();
        log.info("客户端连接成功, socket.name: " + socket.getClass());

        // 3. 读取客户端要下载的文件名
        InputStream inputStream = socket.getInputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        String fileName = "";
        while ((len = inputStream.read(buffer)) != -1) {
            fileName += new String(buffer, 0, len);
        }
        log.info("客户端请求下载的文件名: " + fileName);

        // 4. 从读取文件为字节数组: 没有对应文件,则读取默认文件
        String filePath = "";
        if (fileName.equals("radar.png")) {
            filePath = "D:\\xiaoR\\file_temp\\java_overview\\resource\\picture\\" + fileName;
        } else {
            filePath = "D:\\xiaoR\\file_temp\\java_overview\\resource\\picture\\interferer.png";
        }
        FileInputStream fileInputStream = new FileInputStream(filePath);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while ((len = fileInputStream.read(buffer)) != -1) {
            byteArrayOutputStream.write(buffer, 0, len);
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();

        // 5. 将字节数组写入到socket的字节流中
        OutputStream outputStream = socket.getOutputStream();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        bufferedOutputStream.write(byteArray);
        socket.shutdownOutput();    // 结束标记
        log.info("文件发送完毕");

        // 6. 关闭资源
        bufferedOutputStream.close();
        byteArrayOutputStream.close();
        fileInputStream.close();
        socket.close();
        server.close();
    }
}
