package sort;

import java.util.Arrays;

/**
 * 快速排序
 * 时间复杂度：最好 O(n log n) 最坏 O(n^2) 平均 O(n log n)
 * 空间复杂度：O(1)
 * 原地排序
 * 不稳定排序
 *
 * @author Dave Wang
 */
public class QuickSort {

    static int count = 0;

    public static void quickSort(int[] arr) {
        quickSortCore(arr, 0, arr.length - 1);
    }

    private static void quickSortCore(int[] arr, int p, int r) {
        count++;
        System.out.println("第" + count + "次递归，p = " + p + ", r =" + r);
        if (p >= r) {
            return;
        }

        // 分区
        int pivot = partition(arr, p, r);
        System.out.println("第" + count + "次分区，p = " + p + ", pivot = " + pivot + ", r =" + r);
        // 继续处理分区左边的
        quickSortCore(arr, p, pivot - 1);
        // 继续处理分区右边的
        quickSortCore(arr, pivot + 1, r);
    }

    private static int partition(int[] arr, int p, int r) {
        // 分区点的值【基准值】
        int pivot = arr[r];

        // i，j 都从数组左边开始
        int i = p;
        // 循环 j
        for (int j = p; j < r; j++) {
            // j 指针对应的值小于基准值
            if (arr[j] < pivot) {
                // 交换 i 和 j，并对 i 自增
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
            }
        }

        // 遍历完数组之后，i 左边的值都是小于基准值的
        // 把 i 和 基准值进行调换，基准值左边的就都是小于它的，右边都是大于它的
        arr[r] = arr[i];
        arr[i] = pivot;

        return i;
    }

    private static int partition2(int[] arr, int p, int r) {
        // 分区点的值【基准值】
        int pivot = arr[r];

        // i，j 都从数组左边开始
        int i = p;
        int j = r;
        // 循环 j
        while (i < j) {
            // i 和 j 的顺序是有要求的，如果基础值是最后一位数字，需要先遍历i也就是找大的
            while (i < j && arr[i] <= pivot) {
                i++;
            }
            while (i < j && arr[j] >= pivot) {
                j--;
            }

            if (i < j) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        // 遍历完数组之后，i 左边的值都是小于基准值的
        // 把 i 和 基准值进行调换，基准值左边的就都是小于它的，右边都是大于它的
        arr[r] = arr[i];
        arr[i] = pivot;

        return i;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 44, 38, 5, 47, 15, 36, 26};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
