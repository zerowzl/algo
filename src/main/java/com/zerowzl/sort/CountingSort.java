package com.zerowzl.sort;

import java.util.Arrays;

/**
 * 计数排序，O(n) 时间复杂度，可以排序数据范围很小的数组，并且要求数据必须是正整数（因为用到了数组下标来表示值）
 * 1、使用一个长度是数据范围的数组，下标表示值，元素表示该值出现的次数，记为 c；
 * 2、对 c 进行累加，这样后面的就包含了前面的次数，即小于等于；
 * 3、使用临时数组来存放结果，记为 r；
 * 4、对原数组 a 进行从后往前的遍历：
 * 4-1、数组中元素的值作为 c 的下标取得 c 存放的次数；
 * 4-2、该次数进行-1后作为 r 中的下标存放 a 中的元素值；
 * 4-3、因为 c 中的次数已经被用掉一次了，需要进行 -1 ；
 * 4-4、重复以上步骤。
 *
 * @author Dave Wang
 */
public class CountingSort {

    /**
     * 计数排序，假设数组中存储的都是非负整数。
     *
     * @param a 数组
     * @param n 数组大小
     */
    public static void countingSort(int[] a, int n) {
        if (n <= 1) return;

        // 查找数组中数据的范围
        int max = a[0];
        for (int i = 1; i < n; ++i) {
            if (max < a[i]) {
                max = a[i];
            }
        }

        int[] c = new int[max + 1]; // 申请一个计数数组c，下标大小[0,max]
        // 计算每个元素的个数，放入c中
        for (int i = 0; i < n; ++i) {
            c[a[i]]++;
        }

        // 依次累加
        for (int i = 1; i <= max; ++i) {
            c[i] = c[i - 1] + c[i];
        }

        // 临时数组r，存储排序之后的结果
        int[] r = new int[n];
        // 计算排序的关键步骤，有点难理解
        // c 存的是每个下标（值）小于等于该下标的数量
        for (int i = n - 1; i >= 0; --i) {
            // a 数组值在 c 的位置
            int index = c[a[i]] - 1;
            // 把 index 作为结果数组中的下标
            r[index] = a[i];
            // c 中的被用掉一次了
            c[a[i]]--;
        }

        // 将结果拷贝给a数组
        System.arraycopy(r, 0, a, 0, n);
    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 5, 3, 0, 2, 3, 0, 3};
        countingSort(a, 8);
        System.out.println(Arrays.toString(a));
    }


}
