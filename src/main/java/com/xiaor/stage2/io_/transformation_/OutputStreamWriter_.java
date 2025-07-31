package com.xiaor.stage2.io_.transformation_;

import java.io.*;

public class OutputStreamWriter_ {
    public static void main(String[] args) throws IOException {
        String filePath = "D:\\xiaoR\\file_temp\\java_overview\\dest\\file\\output_stream_writer.txt";
        /**
         *  通过FileOutputStream创建字节流处理对象(节点流)
         *  通过OutputStreamWriter处理字节输出流,并指定编码方式,将字节输出流转换为字符输出流
         */
        String charSet = "gbk";
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(filePath), charSet);
        // BufferWriter: 接收字符输出流(节点流),并将其转换为字符处理流(处理流)
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

        bufferedWriter.write("qianqian");
        bufferedWriter.newLine();
        bufferedWriter.write("毕业于重庆大学");
        bufferedWriter.newLine();
        bufferedWriter.write("20250702");

        /**
         *  处理流务必刷新, 否则数据不会写入文件
         */
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
