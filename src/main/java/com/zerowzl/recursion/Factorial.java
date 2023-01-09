package com.zerowzl.recursion;

/**
 * 阶乘
 *
 * @author Dave Wang
 */
public class Factorial {


    public static int factorial(int n) {
        // 终止条件，0! = 1
        if (n == 0) {
            return 1;
        }

        // 递推公式
        return n * factorial(n - 1);
    }


    public static void main(String[] args) {
        System.out.println("1 的阶乘 >>> " + factorial(1));
        System.out.println("2 的阶乘 >>> " + factorial(2));
        System.out.println("3 的阶乘 >>> " + factorial(3));
        System.out.println("4 的阶乘 >>> " + factorial(4));
        System.out.println("5 的阶乘 >>> " + factorial(5));
        System.out.println("6 的阶乘 >>> " + factorial(6));
        System.out.println("7 的阶乘 >>> " + factorial(7));
        System.out.println("8 的阶乘 >>> " + factorial(8));
        System.out.println("9 的阶乘 >>> " + factorial(9));
        System.out.println("10 的阶乘 >>> " + factorial(10));
        System.out.println("11 的阶乘 >>> " + factorial(11));
        System.out.println("12 的阶乘 >>> " + factorial(12));
        System.out.println("13 的阶乘 >>> " + factorial(13));
        System.out.println("14 的阶乘 >>> " + factorial(14)); // 溢出
    }


}
