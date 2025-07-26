package com.xiaor.stage2.exception;

import java.util.Scanner;

public class TestIntegerException {
    // 如果用户输入的不是一个整数,则持续进行提示并让用户输出
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        while (true) {
            try {
                int number = Integer.parseInt(input);
                System.out.println("成功输入一个整数...");
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                input = scanner.next();
            }
        }
    }
}
