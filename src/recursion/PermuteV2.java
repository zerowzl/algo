package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 全排列
 *
 * @author Dave Wang
 */
public class PermuteV2 {


    /**
     * 一组数的全排列，可以使用回溯的思想，递归的编程方式来解决。
     * 将问题分解为选择一个元素后，在剩余未选元素中继续选择。解的数量是 n!
     * 因为元素不能被重复使用，因此需要记录当前可以选择的元素集合。
     * 终止条件，可用元素全部被选择
     *
     * @param nums 待选元素数组
     * @return 所有的解
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        backtrack(list, res, new ArrayList<>());
        return res;
    }

    private void backtrack(List<Integer> nums, List<List<Integer>> res, ArrayList<Integer> ans) {
        // 终止条件，剩余可用元素为空
        if (nums.isEmpty()) {
            res.add(ans);
            return;
        }

        for (int i = 0; i < nums.size(); i++) {
            // 重新拷贝一份答案
            ArrayList<Integer> newAns = (ArrayList<Integer>) ans.clone();
            newAns.add(nums.get(i));
            // 剩余可用的元素列表
            List<Integer> newNums = new ArrayList<>();
            for (int j = 0; j < nums.size(); j++) {
                // 不包含当前元素
                if (j == i) {
                    continue;
                }
                newNums.add(nums.get(j));
            }
            // 递归调用
            backtrack(newNums, res, newAns);
        }
    }

    public static void main(String[] args) {
        PermuteV2 permute = new PermuteV2();
        List<List<Integer>> res = permute.permute(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(res.toArray()));
    }

}

