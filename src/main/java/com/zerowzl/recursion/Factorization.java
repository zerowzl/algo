package com.zerowzl.recursion;

import java.util.ArrayList;

/**
 * 一个整数可以被分解为多个整数的乘积，例如，6 可以分解为 2x3。
 * 请使用递归编程的方法，为给定的整数 n，找到所有可能的分解（1 在解中最多只能出现 1 次）。
 * 例如，输入 8，输出是可以是 1x8, 8x1, 2x4, 4x2, 1x2x2x2, 1x2x4, ……
 *
 * @author Dave Wang
 */
public class Factorization {


    /**
     * 递推公式：
     * 对当前值进行对比其小的数取模，如果为0说明可以整除，就继续对被模数求解，如果最终遇到被模数为1就返回。
     * 因为 1 只能被使用一次，所以需要传递1是否被使用的标识。
     * 注：没有考虑小数
     *
     * <p>
     * 终止条件：
     * num = 1
     *
     * @param num 待求解数字
     * @return 所有符合条件的解，使用二维数组的方式输出
     */
    public static ArrayList<ArrayList<Integer>> factorization(int num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        factorizationCore(num, res, new ArrayList<>());
        return res;
    }


    private static void factorizationCore(int num, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> ans) {
        if (num == 1) {
            if (!ans.contains(1)) {
                ans.add(1);
            }
            res.add(ans);
            return;
        }

        for (int i = 1; i <= num; i++) {
            if (ans.contains(1) && i == 1) {
                continue;
            }
            if (num % i == 0) {
                ArrayList<Integer> newAns = (ArrayList<Integer>) ans.clone();
                newAns.add(i);
                factorizationCore(num / i, res, newAns);
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(factorization(8));
    }


}
