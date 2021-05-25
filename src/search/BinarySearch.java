package search;

/**
 * 二分查找，普通的二分查找，对一个有序、无重复元素的数组进行查找
 * 时间复杂度可以达到 O(logn)，因为每次都能将原数组缩小为原数组大小的一半
 * 但要求源数据 1）数组 2）有序 3）无重复元素（重复元素需要额外的处理逻辑）
 * <p>
 * 二分查找的变体（存在重复元素）
 * 1、查找第一个等于给定值的元素
 * 2、查找最后一个等于给定值的元素
 * 3、查找第一个大于等于给定值的元素
 * 4、查找最后一个小于等于给定值的元素
 *
 * @author Dave Wang
 */
public class BinarySearch {

    /**
     * 对一个有序、无重复元素的数组进行查找指定元素
     *
     * @param a      待查找数组
     * @param target 目标值
     * @return 如果不存在返回 -1，存在返回目标值在数组中的下标
     */
    public static int basicBinarySearch(int[] a, int target) {
        if (a == null || a.length == 0) {
            return -1;
        }

        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            // 计算中点
            // mid = (low + high) / 2;
            // >>2 = /2
            int mid = low + ((high - low) >> 2);
            if (a[mid] == target) { // 找到了
                return mid;
            } else if (a[mid] > target) { // 中点值大于目标值，继续找左边的
                high = mid - 1;
            } else { // 中点值小于目标值，继续找右边的
                low = mid + 1;
            }
        }
        // 没找到
        return -1;
    }

    /**
     * 查找第一个等于给定值的元素
     *
     * @param a      源数组
     * @param target 目标值
     * @return 如果不存在返回 -1，存在返回目标值在数组中的下标
     */
    public static int firstEqualBinarySearch(int[] a, int target) {
        if (a == null || a.length == 0) {
            return -1;
        }

        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > target) {
                high = mid - 1;
            } else if (a[mid] < target) {
                low = mid + 1;
            } else {
                // 相等了，但是因为存在重复元素，需要增加两个条件：1）当前下标是第一个元素；2）前面一个元素不等于
                if (mid == 0 || a[mid - 1] != target) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }

        // 没找到
        return -1;
    }

    /**
     * 查找最后一个等于给定值的元素
     *
     * @param a      源数组
     * @param target 目标值
     * @return 如果不存在返回 -1，存在返回目标值在数组中的下标
     */
    public static int lastEqualBinarySearch(int[] a, int target) {
        if (a == null || a.length == 0) {
            return -1;
        }

        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > target) {
                high = mid - 1;
            } else if (a[mid] < target) {
                low = mid + 1;
            } else {
                // 如果是最后一个元素 或者 后面一个元素不等于目标值那就说明当前值就是最后一个等于目标值的元素
                if (mid == a.length - 1 || a[mid + 1] != target) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }

        // 没找到
        return -1;
    }

    /**
     * 第一个大于等于给定值的元素
     *
     * @param a      源数组
     * @param target 目标值
     * @return 如果不存在返回 -1，存在返回目标值在数组中的下标
     */
    public static int firstGEBinarySearch(int[] a, int target) {
        if (a == null || a.length == 0) {
            return -1;
        }

        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            // 中间值大于等于目标值的时候，看一下前一个元素的值是多少，
            // 如果小于目标值说明当前值就是第一个大于的值
            if (a[mid] >= target) {
                if (mid == 0 || a[mid - 1] < target) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }

        // 没找到
        return -1;
    }

    /**
     * 查找最后一个小于等于给定值的元素
     *
     * @param a      源数组
     * @param target 目标值
     * @return 如果不存在返回 -1，存在返回目标值在数组中的下标
     */
    public static int lastLEBinarySearch(int[] a, int target) {
        if (a == null || a.length == 0) {
            return -1;
        }

        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] <= target) {
                // 小于等于的时候需要看一下当前元素是不是最后一个元素，是就直接返回
                // 或者后面一个元素大于给定值了，那当前元素也就是最后一个小于等于给定值的元素
                if (mid == a.length - 1 || a[mid + 1] > target) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else {
                high = mid - 1;
            }
        }

        // 没找到
        return -1;
    }


    public static void main(String[] args) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 基础二分查找");
        int[] a = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(basicBinarySearch(a, 1));
        System.out.println(basicBinarySearch(a, 2));
        System.out.println(basicBinarySearch(a, 3));
        System.out.println(basicBinarySearch(a, 4));
        System.out.println(basicBinarySearch(a, 5));
        System.out.println(basicBinarySearch(a, 6));
        System.out.println(basicBinarySearch(a, 7));

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 查找第一个等于给定值");
        int[] a2 = new int[]{1, 1, 1, 2, 2, 3, 4, 5, 6};
        System.out.println(firstEqualBinarySearch(a2, 1));
        System.out.println(firstEqualBinarySearch(a2, 2));
        System.out.println(firstEqualBinarySearch(a2, 4));
        System.out.println(firstEqualBinarySearch(a2, 6));
        System.out.println(firstEqualBinarySearch(a2, 7));

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 查找最后一个等于给定值");
        int[] a3 = new int[]{1, 1, 1, 2, 2, 3, 4, 5, 6};
        System.out.println(lastEqualBinarySearch(a3, 1));
        System.out.println(lastEqualBinarySearch(a3, 2));
        System.out.println(lastEqualBinarySearch(a3, 4));
        System.out.println(lastEqualBinarySearch(a3, 6));
        System.out.println(lastEqualBinarySearch(a3, 7));

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 查找第一个大于等于给定值");
        int[] a4 = new int[]{1, 1, 3, 4, 5, 6};
        System.out.println(firstGEBinarySearch(a4, 1));
        System.out.println(firstGEBinarySearch(a4, 2));

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 查找最后一个小于等于给定值");
        int[] a5 = new int[]{1, 1, 3, 4, 5, 6};
        System.out.println(lastLEBinarySearch(a5, 1));
        System.out.println(lastLEBinarySearch(a5, 2));

    }


}
