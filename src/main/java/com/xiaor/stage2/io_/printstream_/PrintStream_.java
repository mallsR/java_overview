package com.xiaor.stage2.io_.printstream_;

import java.io.IOException;
import java.io.PrintStream;

public class PrintStream_ {
    public static void main(String[] args) throws IOException {
        PrintStream out = System.out;
        // 默认情况下,PrintStream的输出位置是标准输出,即显示器
        out.print("hello, xiaoR~");
        // print的底层也是调用write
        out.write("hello".getBytes());
        out.close();

        /**
         * 修改打印流的输出位置/设备到targetPath
         */
        String targetPath = "D:\\xiaoR\\file_temp\\java_overview\\dest\\file\\print_stream.txt";
        System.setOut(new PrintStream(targetPath));
        System.out.println("hello, xiaoR~");
    }
}
