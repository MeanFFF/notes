package zuo.bs;

import zuo.basesort.CommonUtils;

import java.util.Arrays;

/**
 * @author gangping.liu
 * @date 20210119
 * 在一个有序数组中，找<=某个数最右侧的位置
 */
public class BinarySearchNearRight {

    /**
     * 排他性原则出现就可以二分！
     * 可以排掉一边的逻辑，就可以二分
     * @param arr
     * @param value
     * @return
     */
    public static int binarySearchNearRight(int[] arr, int value) {
        if (arr == null || arr.length < 1) {
            return -1;
        }
        int l = 0;
        int r = arr.length - 1;
        int index = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] <= value) {
                index = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        check();
    }

    public static int search(int[] arr, int value) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] <= value) {
                return i;
            }
        }
        return -1;
    }

    public static void check() {
        int maxTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        for (int i = 0; i < maxTime; i++) {
            int[] arr = CommonUtils.generateRandomArray(maxSize, maxValue);
            Arrays.sort(arr);

            int value = (int)(Math.random() * maxValue);
            int result1 = binarySearchNearRight(arr, value);
            int result2 = search(arr, value);

            if (result1 != result2) {
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
