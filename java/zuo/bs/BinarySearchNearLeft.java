package zuo.bs;

import zuo.basesort.CommonUtils;

import java.util.Arrays;

/**
 * @author gangping.liu
 * @date 20210119
 * 在一个有序数组中，找>=某个数最左侧的位置
 */
public class BinarySearchNearLeft {

    public static int binarySearchNearLeft(int[] arr, int value) {
        if (arr == null || arr.length < 1) {
            return -1;
        }
        // >=value 最左侧位置
        int l = 0;
        int r = arr.length - 1;
        int index = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            // arr[mid] >= value
            if (arr[mid] >= value) {
                /*
                将此时符合条件的结果存储起来，之后找不到其他更符合条件的结果时，使用当前结果
                 */
                index = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        check();
    }

    public static int search(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= value) {
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
            int result1 = binarySearchNearLeft(arr, value);
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
