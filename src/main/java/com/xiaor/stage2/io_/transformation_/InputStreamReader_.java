package com.xiaor.stage2.io_.transformation_;

import java.io.*;

public class InputStreamReader_ {
    public static void main(String[] args) throws IOException {
        String filePath = "D:\\xiaoR\\file_temp\\java_overview\\resource\\file\\input_stream_reader.txt";
        /**
         *  1. 通过FileInputStream创建字节流处理对象(节点流)
         *  2. 通过InputStreamReader处理字节输入流, 指定编码方式(需要指定为文件的编码方式,否则会报错), 将字节输入流转换为字符输入流
         */
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath), "gbk");
        // 将字符节点流传入字符处理流
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        bufferedReader.close();
    }
}
