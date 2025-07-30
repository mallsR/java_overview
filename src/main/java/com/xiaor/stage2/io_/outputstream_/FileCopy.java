package com.xiaor.stage2.io_.outputstream_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileCopy {
    public static void main(String[] args) throws IOException {
        // 一边读,一边存
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要复制的文件名(绝对路径):");
        String srcFileName = scanner.nextLine();
        System.out.println("请输入要保存的文件名(绝对路径):");
        String destFileName = scanner.nextLine();

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        byte[] bytes = new byte[1024];
        int readLength = 0;

        try {
            // 创建输入输出流对象
            fileInputStream = new FileInputStream(srcFileName);
            fileOutputStream = new FileOutputStream(destFileName);

            while ((readLength = fileInputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, readLength);
                fileOutputStream.flush();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileInputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
