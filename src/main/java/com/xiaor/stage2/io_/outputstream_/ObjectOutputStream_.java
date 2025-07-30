package com.xiaor.stage2.io_.outputstream_;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutputStream_ {
    public static void main(String[] args) {
        // 由于ObjectOutputStream序列化时,会按自己的格式进行保存,所以指定文件名时,不用指定后缀
        String filePath = "D:\\xiaoR\\file_temp\\java_overview\\dest\\file\\object_info";
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));

            // 保存数据时,要用对应形式的write方法
            objectOutputStream.writeInt(2021);      // int会自动包装为Integer
            objectOutputStream.writeInt(2022);
            objectOutputStream.writeUTF("20240629");
            objectOutputStream.writeObject(new Student("xiaoR", 27));

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                objectOutputStream.close();
                System.out.println("数据保存完毕(序列化形式)...");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

