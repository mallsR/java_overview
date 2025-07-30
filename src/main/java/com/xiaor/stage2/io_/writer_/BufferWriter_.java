package com.xiaor.stage2.io_.writer_;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferWriter_ {

    public static void main(String[] args) throws IOException {
        String filePath = "D:\\xiaoR\\file_temp\\java_overview\\dest\\file\\write_char_file1.txt";

        // 此处的true,表示以追加方式写入文件
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true));

        bufferedWriter.write("hello ");
        bufferedWriter.write("world");
        bufferedWriter.newLine();       // 插入一个与系统编码相匹配的换行符
        bufferedWriter.write("java");
        bufferedWriter.newLine();

        bufferedWriter.flush();

        // 关闭处理流对象,底层会自动关闭其内部的节点流
        bufferedWriter.close();
    }
}
