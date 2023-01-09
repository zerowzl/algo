package com.zerowzl.sort;

import java.util.Arrays;

/**
 * 插入排序
 * 时间复杂度：最好 O(n) 最坏 O(n^2) 平均 O(n^2)
 * 空间复杂度：O(1)
 * 原地排序
 * 稳定排序
 *
 * @author Dave Wang
 */
public class InsertionSort {

    public void insertionSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            // 当前需要比较的元素
            int value = arr[i];
            int j = i - 1;
            // 依次比较前一位
            for (; j >= 0; j--) {
                // 如果大于就将当前值赋值给后一位
                if (arr[j] > value) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            // 最后将当前需要比较的元素放到正确的位置
            arr[j + 1] = value;
        }
    }

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        int[] arr = new int[]{3, 6, 5, 2, 3, 1};
        insertionSort.insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }


}
