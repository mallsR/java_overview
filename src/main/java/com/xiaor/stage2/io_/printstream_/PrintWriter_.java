package com.xiaor.stage2.io_.printstream_;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriter_ {
    public static void main(String[] args) throws IOException {
        // 标准输出 显示器
        PrintWriter printWriter1 = new PrintWriter(System.out);
        printWriter1.println("hello, xiaoR~");

        /**
         *  PrintWriter是一个处理流, 使用了装饰器模式, 内部有一个Writer类型的属性out
         */
        // 输出到文件
        String filePath = "D:\\xiaoR\\file_temp\\java_overview\\dest\\file\\print_writer.txt";
        PrintWriter printWriter2 = new PrintWriter(new FileWriter(filePath));
        printWriter2.println("hello, xiaoR~");
        printWriter2.close();   // flush + 关闭流
    }
}
