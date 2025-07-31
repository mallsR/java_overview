package com.xiaor.stage2.io_.outputstream_;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class FileOutputStream_ {
    public static void main(String[] args) {

    }

    @Test
    public void writeFile() throws IOException {
        ArrayList<String> strings = new ArrayList<>(4);
        strings.add("xiaoR");
        strings.add("love");
        strings.add("qianqian");
        strings.add("20240629");

        String filePath = "D:\\xiaoR\\file_temp\\java_overview\\dest\\file\\new_file2.txt";

        FileOutputStream fileOutputStream = null;
        try {
            /**
             *  在文件不存在时会自动创建文件, 但如果目录不存在,则报异常
             *  默认以覆盖方式写入文件, 如果需要添加方式写入,则需要使用第二个参数 append: true
             */
            fileOutputStream = new FileOutputStream(filePath, true);

            for (String string : strings) {
                fileOutputStream.write(string.getBytes());      // 主要将字符串转为byte数组
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
