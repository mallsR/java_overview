package com.xiaor.stage2.io_.outputstream_;

import java.io.*;

/**
 *  利用BufferInputStream和BufferOutputStream进行字节流拷贝
 *  二进制方式也可以操作文本文件
 */
public class BufferByteCopy {
    public static void main(String[] args) {
        String srcPicturePath = "D:\\xiaoR\\file_temp\\java_overview\\resource\\picture\\radar.png";
        String destPicturePath = "D:\\xiaoR\\file_temp\\java_overview\\dest\\picture\\radar_copy.png";

        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(srcPicturePath));
            // true表示以追加方式进行写入
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destPicturePath, true));

            byte[] buffer = new byte[1024];
            int readLength = 0;
            while ((readLength = bufferedInputStream.read(buffer)) != -1) {
                bufferedOutputStream.write(buffer, 0, readLength);
                bufferedOutputStream.flush();
            }
            System.out.println("文件复制成功...");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
