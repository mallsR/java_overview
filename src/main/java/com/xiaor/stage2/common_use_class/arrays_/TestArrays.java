package com.xiaor.stage2.common_use_class.arrays_;

import java.util.Arrays;
import java.util.Comparator;

public class TestArrays {
    public static void main(String[] args) {

        Integer[] integers = {10, 20, 30};

        // 1. 显示数组
        System.out.println(Arrays.toString(integers));


        Integer[] integers2 = {0, -1, 90, -5, 16, 7};

        Arrays.sort(integers2, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        System.out.println("=======排序后=======");
        System.out.println(Arrays.toString(integers2));
    }
}
