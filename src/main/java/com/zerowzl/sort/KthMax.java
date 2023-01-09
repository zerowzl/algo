package com.zerowzl.sort;

/**
 * 第 K 大元素
 *
 * @author Dave Wang
 */
public class KthMax {

    public static int findKthMax(int[] arr, int kthMax) {
        return findKthMax(arr, 0, arr.length - 1, kthMax);
    }


    // 如果 p+1=K，那 A[p]就是要求解的元素；如果 K>p+1, 说明第 K 大元素出现在 A[p+1...n-1]区间，
    // 我们再按照上面的思路递归地在 A[p+1...n-1]这个区间内查找。
    // 同理，如果 K<p+1，那我们就在 A[0...p-1]区间查找。
    private static int findKthMax(int[] arr, int p, int r, int kthMax) {
        int pivot = partition(arr, p, r);

        while (pivot + 1 != kthMax) {
            if (pivot + 1 < kthMax) {
                pivot = partition(arr, pivot + 1, r);
            }
            if (pivot + 1 > kthMax) {
                pivot = partition(arr, p, pivot - 1);
            }
        }

        return arr[pivot];
    }

    // 从大到小排序
    private static int partition(int[] arr, int p, int r) {
        // 分区点的值【基准值】
        int pivot = arr[r];

        // i，j 都从数组左边开始
        int i = p;
        // 循环 j
        for (int j = p; j < r; j++) {
            // j 指针对应的值大于基准值
            if (arr[j] > pivot) {
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

    public static void main(String[] args) {
        int[] arr = new int[]{3, 44, 38, 5, 47, 15, 36, 26};
        System.out.println(findKthMax(arr, 5));
    }


}
