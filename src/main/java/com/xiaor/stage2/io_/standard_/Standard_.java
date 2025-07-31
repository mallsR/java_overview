package com.xiaor.stage2.io_.standard_;

import java.util.Scanner;

public class Standard_ {
    public static void main(String[] args) {
        /**
         * public static final InputStream in = null;
         * System.in 编译类型 InputStream
         * System.in 运行类型 BufferedInputStream
         * 表示的是标准输入 键盘
         */
        System.out.println(System.in);

        /**
         * public static final PrintStream out = null;
         * System.out 编译类型 PrintStream
         * System.out 运行类型 PrintStream
         * 表示的是标准输出 显示器
         */
        System.out.println(System.out);

        System.out.println("hello~");

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入内容:");
        String next = scanner.next();
        System.out.println("输入的内容是:" + next);
    }
}
