package com.xiaor.common_use_class.homework;

public class StringHomework {
    public static void main(String[] args) {
        String userName = "xiaoR";
        String password = "qianqian";
        String email = "xiaoR@qianqian.com";

        try {
            userRegister(userName, password, email);
            System.out.println("用户注册成功...");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void userRegister(String userName, String password, String email) {
        // 初始校验
        if(! (userName != null && password != null && email != null)) {
            throw new RuntimeException("用户名,密码,邮箱均不能为null...");
        }

        // 判断用户名是否符合长度要求
        int userNameLength = userName.length();
        if (! (userNameLength >= 2 && userNameLength <= 5)) {
            throw new RuntimeException("用户名长度需要在2-5位...");
        }

        // 判断密码是否全为数字
        if(!(password.length() == 8 && idChar(password))) {
            throw new RuntimeException("要求密码长度为6,且全为数字...");
        }

        // 判断@是否在.之前
        int atIdx = email.indexOf('@');
        int dotIdx = email.indexOf('.');
        if(!(atIdx > 0 && dotIdx > atIdx)) {
            throw new RuntimeException("邮箱需要包含@和.,并且@需要在.之前...");
        }
    }

    /**
     * 判断字符串是否全为数字
     * @param str
     * @return
     */
    public static boolean idDigit(String str) {
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if(!(chars[i] >= '0' && chars[i] <= '9')) {
                return false;
            }
        }

        return true;
    }

    /**
     * 判断字符串是否全为英文字母
     * @param str
     * @return
     */
    public static boolean idChar(String str) {
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if(!((chars[i] >= 'a' && chars[i] <= 'z') || (chars[i] >= 'A' && chars[i] <= 'Z'))) {
                return false;
            }
        }

        return true;
    }
}


