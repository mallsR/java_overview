package com.xiaor.class_and_object.homework.homework3;

public class TestCellPhone {
    public static void main(String[] args) {
        CellPhone cellPhone = new CellPhone();
        cellPhone.testWork(new Calculator() {
            @Override
            public double work(double... nums) {
                double result = 0;
                for (double num : nums) {
                    result += num;
                }
                return result;
            }
        });
    }
}
