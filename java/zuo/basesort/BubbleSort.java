package zuo.basesort;

import java.util.Arrays;

/**
 * @author gangping.liu
 * @date 20210119
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        /*
        0~N-1 上，将最大的交换到最右边（N-1）
        0~N-2 上，将最大的交换到最右边（N-2）
        ...
        0~1 上，将最大的交换到最右边（1）
         */
        for (int i = arr.length - 1; i > 0; i--) {
            // 内循环的范围是：0～i；最小是0～1
            for (int k = 0; k < i; k++) {
                /*
                0 1上，将最大的交换到最右边（1）
                1 2上，将最大的交换到最右边（2）
                2 3上，将最大的交换到最右边（3）
                3 4上，将最大的交换到最右边（4）
                ...
                i-1 i上，将最大的交换到最右边（i）

                k < i；留一个结尾k + 1；
                 */
                if (arr[k] > arr[k + 1]) {
                    CommonUtils.swap(arr, k, k + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int testTimes = 500000;
        int maxSize = 100;
        int maxValue = 100;

        for (int k = 0; k < testTimes; k++) {
            int[] arr1 = CommonUtils.generateRandomArray(maxSize, maxValue);
            int[] arr2 = CommonUtils.copyOf(arr1);
            bubbleSort(arr1);
            Arrays.sort(arr2);
            if (!CommonUtils.isEqual(arr1, arr2)) {
                System.out.println("Oh no!");
                System.out.println(Arrays.toString(arr1));
                System.out.println(Arrays.toString(arr2));
                break;
            }
        }
        System.out.println("nice!");

    }

}
