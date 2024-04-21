package org.example.classCode;

public class LeetCode135 {
    public static int candy(int[] ratings) {
        if (ratings.length == 1)
            return 1;
        int length = ratings.length;
        int result = 1;
        int isMonotonous = 0; // 整数的单调递增的，负数为单调递减，0代表刚刚是平局重新开始
        int gap = 0;
        for (int i = 1; i < length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                // 递增
                gap = 0;
                isMonotonous = isMonotonous > 0 ? isMonotonous + 1 : 1;
                result += isMonotonous + 1;
            } else if (ratings[i] < ratings[i - 1]) {
                if (isMonotonous < 0) {
                    if(gap > -isMonotonous){
                        isMonotonous--;
                        result -= isMonotonous;
                    }else{
                        isMonotonous--;
                        result += 1 - isMonotonous;
                    }
                } else if (isMonotonous > 0) {
                    gap = isMonotonous;
                    isMonotonous = -1;
                    result -= isMonotonous;
                } else {
                    isMonotonous = -1;
                    result += 2;
                }
            } else {
                // 平
                gap = 0;
                result += 1;
                isMonotonous = 0;
            }

            System.out.println(result);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input =new int[]{1,6,8,9,7,4,10,10,5,3,2};
        System.out.println(candy(input));
    }
}
