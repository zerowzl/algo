package com.zerowzl.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 假设有一个 4 位字母密码，每位密码是 a～e 之间的小写字母。你能否编写一段代码，来暴力破解该密码？
 * （提示：根据可重复排列的规律，生成所有可能的 4 位密码。）
 *
 * @author Dave Wang
 */
public class BruteForce {

    /**
     * 暴力破解，使用回溯算法，解的数量 n^n （4 ^ 4 = 256）
     *
     * @param chars 待选的字符数组
     * @return 所有的解
     */
    public static List<String> bruteForce(String[] chars) {
        List<String> res = new ArrayList<>();
        StringBuilder ans = new StringBuilder();
        backtrack(chars, res, ans);
        return res;
    }

    private static void backtrack(String[] chars, List<String> res, StringBuilder ans) {
        // 终止条件，ans 中存在的字符和源字符长度一致
        if (ans.length() == chars.length) {
            res.add(ans.toString());
            return;
        }

        for (String aChar : chars) {
            // 遍历添加元素到新的结果中
            StringBuilder newAns = new StringBuilder(ans);
            newAns.append(aChar);
            // 递归调用
            backtrack(chars, res, newAns);
        }
    }

    public static void main(String[] args) {
        List<String> res = bruteForce(new String[]{"a", "b", "c", "d"});
        System.out.println(res);
    }

}
