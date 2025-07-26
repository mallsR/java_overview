package com.xiaor.stage3.network_.socket_.uploadfile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamUtils {
    public static byte[] streamToBytes(InputStream inputStream) throws IOException {
        /**
         * 创建字节数组输出流对象
         */
        // 创建输出流对象
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        byte[] buffer = new byte[1024];
        int len;
        while ((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);  // 把读取到的数据写入bos
        }

        byte[] byteArray = bos.toByteArray();       // 将bos转换为字节数组
        bos.close();
        return byteArray;
    }
}
