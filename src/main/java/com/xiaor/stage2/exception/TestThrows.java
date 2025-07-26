package com.xiaor.stage2.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TestThrows {
    public static void main(String[] args) {

    }

    public void readFile() throws FileNotFoundException {
        // 1. 通过throws FileNotFoundException,将编译时异常上抛到的其调用者处理
        // 2. throws后面也可以跟列表,表示程序能接收多种格式的异常
        FileInputStream fileInputStream = new FileInputStream("xiaoR.word");
    }
}
