package zuo.bs;

import zuo.basesort.CommonUtils;

import java.util.Arrays;

/**
 * @author gangping.liu
 * @date 20210119
 */
public class BinarySearch {

    /**
     * 经典二分：在有序数组中找值
     *
     * 遍历 -> 最坏情况在最右找到 -> 时间复杂度O(N)
     *
     * 有序数组没必要遍历；先判断中点是否符合value；
     *  如果比value大，value不可能出现在中点右边，则向左半边找value（剪右枝）
     *  如果比value小，value不可能出现在中点左边，则向右半边找value（剪左枝）
     * 重复以上操作；
     *
     * N -> N/2 -> N/4 -> N/8 -> ... -> 1
     * N = 2^x，则需要折半x次
     * 得x = logN
     * @param arr
     * @param value
     * @return
     */
    public static int binarySearch(int[] arr, int value) {
        int l = 0;
        int r = arr.length - 1;
        /*
        https://www.cnblogs.com/kyoner/p/11080078.html
        while(left <= right)的终止条件是 left == right + 1，写成区间的形式就是 [right + 1, right]，或者带个具体的数字进去 [3, 2]，可见这时候搜索区间为空，因为没有数字既大于等于 3 又小于等于 2 的吧。所以这时候 while 循环终止是正确的，直接返回 -1 即可。

        while(left < right)的终止条件是 left == right，写成区间的形式就是 [right, right]，或者带个具体的数字进去 [2, 2]，这时候搜索区间非空，还有一个数 2，但此时 while 循环终止了。也就是说这区间 [2, 2] 被漏掉了，索引 2 没有被搜索，如果这时候直接返回 -1 就可能出现错误。
         */
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == value) {
                return mid;
            } else if (arr[mid] > value) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public static int search(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        check();
    }

    public static void check() {
        int maxTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        for (int i = 0; i < maxTime; i++) {
            int[] arr = CommonUtils.generateRandomArray(maxSize, maxValue);
            Arrays.sort(arr);

            int value = (int)(Math.random() * maxValue);
            int result1 = binarySearch(arr, value);
            int result2 = search(arr, value);

            if (result1 != result2 && arr[result1] != arr[result2]) {
                System.out.println("oh no!");
                System.out.println(Arrays.toString(arr) + ": " + result1);
                System.out.println(Arrays.toString(arr) + ": " + result2);
                System.out.println(value);
                break;
            }
        }
        System.out.println("nice!");
    }

}
