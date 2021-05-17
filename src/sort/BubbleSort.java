package sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 时间复杂度：最好 O(n) 最坏 O(n^2) 平均 O(n^2)
 * 空间复杂度：O(1)
 * 原地排序
 * 稳定排序
 *
 * @author Dave Wang
 */
public class BubbleSort {


    public void bubbleSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            // 如果一个循环没有修改，说明已经是有序的了
            boolean isNotUpdate = true;
            // -i 是因为后面已经排序了
            // -1 是因为要比较后面一个数
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isNotUpdate = false;
                }
            }

            if (isNotUpdate) {
                break;
            }
        }
    }


    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] arr = new int[]{3, 6, 5, 2, 3, 1};
        bubbleSort.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
