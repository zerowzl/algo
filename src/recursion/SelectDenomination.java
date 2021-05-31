package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 限定总和的情况下选择所有可能的面值
 *
 * @author Dave Wang
 */
public class SelectDenomination {

    public static final List<Integer> DENOMINATION = Arrays.asList(1, 2, 5, 10);


    /**
     * DENOMINATION 是所有可用的面值，并且是可以重复使用的。
     * 可以使用递归的方式来求解，第一个面值确定后，问题就变成了求解 num - 当前选择面值。
     * 因为可以重复使用，不需要单独记录剩余可选的面值。
     * 终止条件是当前和等于待求和或者大于待求和，等于的时候就是正确的解，大于的时候不是符合条件的解。
     *
     * @param num 总和
     * @return 所有符合条件的解
     */
    public static ArrayList<ArrayList<Integer>> select(int num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        select(num, res, new ArrayList<>());
        return res;
    }


    public static void select(int num, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> ans) {
        if (num == 0) {
            res.add(ans);
        } else if (num < 0) {
            return;
        } else {
            for (Integer denomination : DENOMINATION) {
                ArrayList<Integer> newAns = (ArrayList<Integer>) ans.clone();
                newAns.add(denomination);
                int newNum = num - denomination;
                select(newNum, res, newAns);
            }
        }
    }


    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> res = select(10);
        for (ArrayList<Integer> ans : res) {
            System.out.println(ans);
        }
    }


}
