package com.xiaor.stage2.exception;

public class TestException {
    public static void main(String[] args) {
        System.out.println(Exception_.method());
    }
}

class Exception_ {
    public static int method() {
        int i = 1;
        try {
            ++i;
            String[] names = new String[3];
            if (names[1].equals("tom")) {
                System.out.println(names[1]);
            } else {
                names[3] = "xiaoR";
            }
            return 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            return 2;
        } catch (NullPointerException e) {
            return ++i;     // 保存临时变量temp = 3,待执行完finally之后,再进行返回
        } finally {
            ++i;
            System.out.println("i = " + i);
        }
    }
}
