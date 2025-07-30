package com.xiaor.stage2.io_.inputstream_;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStream_ {
    public static void main(String[] args) {
        
    }

    @Test
    public void readFile1() throws IOException {
        String filePath = "D:\\xiaoR\\file_temp\\java_overview\\dest\\file\\new_file1.txt";

        FileInputStream fileInputStream = null;
        byte[] buf = new byte[128];
        int readLenth = 0;

        try {
            fileInputStream = new FileInputStream(filePath);
            /**
             *   如果读取正常,则返回实际读取的字节数, 读取完毕,则返回-1
             */
            while ((readLenth = fileInputStream.read(buf)) != -1) {
                System.out.println(new String(buf, 0, readLenth));
            }
        } catch (IOException e) {
            System.out.println("读取文件失败: " +e.toString());
        } finally {
            // 关闭文件流,释放资源
            fileInputStream.close();
        }
    }
}
