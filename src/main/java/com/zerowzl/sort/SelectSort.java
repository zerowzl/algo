package com.zerowzl.sort;

import java.util.Arrays;

/**
 * 选择排序
 * 时间复杂度：最好 O(n) 最坏 O(n^2) 平均 O(n^2)
 * 空间复杂度：O(1)
 * 原地排序
 * 不稳定排序
 *
 * @author Dave Wang
 */
public class SelectSort {


    public void selectSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            int value = arr[i];

            // 得到数组剩余元素中的最小值的 index
            int min = i + 1;
            for (int j = i + 2; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            // 比较当前元素和剩余数组最小值
            if (value > arr[min]) {
                arr[i] = arr[min];
                arr[min] = value;
            }
        }
    }


    public static void main(String[] args) {
        SelectSort selectSort = new SelectSort();
        int[] arr = new int[]{3, 6, 5, 2, 3, 1};
        selectSort.selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
