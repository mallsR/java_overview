package com.xiaor.stage2.io_.reader_;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReader_ {
    public static void main(String[] args) throws IOException {
        // 创建一个FileReader对象
        FileReader reader = null;

        // 创建一个char[]
        char[] chars = new char[1024];
        try {
            reader = new FileReader("D:\\xiaoR\\file_temp\\java_overview\\dest\\file\\read_char_file1.txt");
            // 读取文件
            int readCount = reader.read(chars);
            while (readCount != -1) {
                // 输出内容
                System.out.print(new String(chars, 0, readCount));
                // 继续读取
                readCount = reader.read(chars);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            // 关闭流
            if (reader != null) {
                reader.close();
            }
        }
    }
}
