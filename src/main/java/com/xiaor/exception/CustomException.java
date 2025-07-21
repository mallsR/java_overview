package com.xiaor.exception;

public class CustomException {
    public static void main(String[] args) {
        int age = 180;
        if (!(age >= 18 && age < 120)) {
            throw new AgeException("年龄需要在18至120岁...");
        }
        System.out.println("你的年龄符合正常区间...");
    }
}

// 1. 建议把自定义异常继承自RuntimeException,好处在于可以使用默认的处理机制
class AgeException extends RuntimeException {
    public AgeException(String message) {
        super(message);
    }
}
