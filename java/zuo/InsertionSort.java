package zuo;

import java.util.Arrays;

/**
 * @author gangping.liu
 * @date 20210119
 */
public class InsertionSort {

    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        /*
        0~0 上实现有序
        0~1 上实现有序
        0~2 上实现有序
        0~3 上实现有序
        ...
        0~N-1 上实现有序
         */
        for (int i = 1; i <= arr.length - 1; i++) {
            for (int k = i; k > 0 && arr[k] < arr[k - 1]; k --) {
                /*
                看arr[k]是否比前面的值更小，如果更小则交换，使其有序
                再arr[k-1]看前面

                排队时，看前面是不是有比自己更高的人，有则交换

                因为前面已经是有序的了，所以arr[k] >= arr[k-1]之后 就可以不用比较了
                 */
                CommonUtils.swap(arr, k, k - 1);
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
            insertionSort(arr1);
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