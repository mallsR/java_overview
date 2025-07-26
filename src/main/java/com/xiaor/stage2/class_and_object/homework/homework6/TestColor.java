package com.xiaor.stage2.class_and_object.homework.homework6;

public class TestColor {
    public static void main(String[] args) {
        Color color = Color.BLUE;
        switch (color) {
            case BLUE:
                System.out.println("Blue");
                break;
            case RED:
                System.out.println("Red");
                break;
            case GREEN:
                System.out.println("Green");
                break;
            case YELLOW:
                System.out.println("Yellow");
                break;
            case BLACK:
                System.out.println("Black");
                break;
            default:
                color.show();
        }
    }
}
