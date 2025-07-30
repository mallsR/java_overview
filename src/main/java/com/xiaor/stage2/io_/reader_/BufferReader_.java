package com.xiaor.stage2.io_.reader_;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferReader_ {
    public static void main(String[] args) throws IOException {
        String filePath = "D:\\xiaoR\\file_temp\\java_overview\\dest\\file\\new_file1.txt";
        /**
         *  此处为BufferReader传入一个FileReader对象,并在内部利用Reader引用进行接收
         */
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

        String line = null;

        /**
         * readLine表示按行读取文件, 返回null时表示读取结束
         */
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        // 只需关闭bufferReader,底层会自动关闭其内部的节点流
        bufferedReader.close();
    }
}
