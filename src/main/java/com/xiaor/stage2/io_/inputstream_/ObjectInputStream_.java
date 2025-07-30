package com.xiaor.stage2.io_.inputstream_;

import com.xiaor.stage2.io_.outputstream_.Student;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStream_ {
    public static void main(String[] args) throws ClassNotFoundException {
        String filePath = "D:\\xiaoR\\file_temp\\java_overview\\dest\\file\\object_info";
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(filePath));

            /**
             * 注意此处的读取顺序,应该要与存入顺序一致,不然会出现问题
             */
            System.out.println(objectInputStream.readInt());
            System.out.println(objectInputStream.readInt());
            System.out.println(objectInputStream.readUTF());
            Object obj = objectInputStream.readObject();
            System.out.println("运行类型: " + obj.getClass());
            System.out.println("obj信息: " + obj);

            /**
             * 但如果想要显式向下转型, 则需要将类声明为公有的,让反序列化过程和序列化过程都能访问同一个类
             * 注意是同一个类
             * 在两个文件类各自建Student类的方式是不行的,因为系统无法分辨这两个类是否是完全一致的
             */
            Student stu = (Student) obj;
            System.out.println("stu信息: " + stu.getName() + " " + stu.getAge());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                objectInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
