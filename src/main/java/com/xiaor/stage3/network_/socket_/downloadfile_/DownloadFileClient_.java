package com.xiaor.stage3.network_.socket_.downloadfile_;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

@Slf4j
public class DownloadFileClient_ {
    public static void main(String[] args) throws IOException {
        // 1. 要下载的文件名
        Scanner scanner = new Scanner(System.in);
        log.info("请输入要下载的文件名:");
        String fileName = scanner.next();

        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        // 2. 构建字符流
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));

        // 3. 发送文件名
        bufferedWriter.write(fileName);
        bufferedWriter.newLine();  // 使用字符流设置结束标记,当然,也阔以使用socket.shutdownOutput();设置结束标记
        bufferedWriter.flush();
        socket.shutdownOutput();

        // 4. 接收发过来的数据
        InputStream inputStream = socket.getInputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while ((len = inputStream.read(buffer)) != -1) {
            byteArrayOutputStream.write(buffer, 0, len);
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();

        // 5. 将数据写入文件
        String filePath = "D:\\xiaoR\\file_temp\\java_overview\\dest\\picture\\" + fileName;
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(filePath));
        bufferedOutputStream.write(byteArray);

        // 6. 关闭资源
        bufferedOutputStream.close();
        byteArrayOutputStream.close();
        inputStream.close();
        bufferedWriter.close();
        socket.close();
        log.info("下载完成");
    }
}
