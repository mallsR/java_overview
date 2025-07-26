package com.xiaor.stage2.io_.files_;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class CreateFile {
    public static void main(String[] args) {
        System.out.println("D:\\xiaoR\\file_temp\\java_overview\\dest\\file\\new_file1");
    }

    @Test
    public void createFile1() {
        String path = "D:\\xiaoR\\file_temp\\java_overview\\dest\\file\\new_file1.txt";
        File file = new File(path);     // 此时只是生成了一个文件对象,并没有创建文件

        try {
            boolean newFile = file.createNewFile();
            System.out.println("创建文件成功=" + newFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *  new File(File parent, String child) 根据父目录文件 + 子路径构建
     */
    @Test
    public void createFile2() {
        String path = "D:\\xiaoR\\file_temp\\java_overview\\dest\\file\\";
        File parentFile = new File(path);

        File file = new File(parentFile, "new_file2.txt");

        try {
            file.createNewFile();
            System.out.println("创建文件夹成功=" +  file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void createFile3() {
        String parentPath = "D:\\xiaoR\\file_temp\\java_overview\\dest\\file\\";
        String filePath = "new_file3.txt";
        File file = new File(parentPath, filePath);

        try {
            file.createNewFile();
            System.out.println("创建文件夹成功=" + file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
