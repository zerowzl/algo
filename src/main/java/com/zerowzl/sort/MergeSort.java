package com.zerowzl.sort;

import java.util.Arrays;

/**
 * 归并排序
 * 时间复杂度：最好 O(n log n) 最坏 O(n log n) 平均 O(n log n)
 * 空间复杂度：O(n)
 * 非原地排序
 * 稳定排序
 *
 * @author Dave Wang
 */
public class MergeSort {

    static int count = 0;
    static int mergeCount = 0;

    public static void mergeSort(int[] arr) {
        mergeSortCore(arr, 0, arr.length - 1);
    }


    private static void mergeSortCore(int[] arr, int p, int r) {
        count++;
        System.out.println("第" + count + "次递归，p = " + p + ", r =" + r);
        // 终止条件
        if (p >= r) {
            return;
        }

        // 计算中位，防止溢出
        int q = p + (r - p) / 2;
        System.out.println("第" + count + "次递归，p = " + p + ", q = " + q + ", r =" + r);
        // 分别处理左半部分和右半部分
        mergeSortCore(arr, p, q);
        mergeSortCore(arr, q + 1, r);
        // 合并 p..q 和 p+1..r 到 p..r
        merge(arr, p, q, r);
        mergeCount++;
        System.out.println("第" + mergeCount + "次合并，p = " + p + ", r =" + r);
    }

    private static void merge(int[] arr, int p, int q, int r) {
        // 比较 p..q 和 p+1..r 两个数组中的元素的大小，合并到临时数组中，小的在前面
        int i = p;
        int j = q + 1;
        int k = 0;
        int[] temp = new int[r - p + 1];

        while (i <= q && j <= r) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // 合并剩余有元素的数组
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }
        while (start <= end) {
            temp[k++] = arr[start++];
        }

        // 将临时数组拷贝到原数组
        for (int l = 0; l <= r - p; l++) {
            arr[p + l] = temp[l];
        }
    }

    public static void main(String[] args) {
        // int[] arr = new int[]{3, 44, 38, 5};
        int[] arr = new int[]{3, 44, 38, 5, 47, 15, 36, 26};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }


}
