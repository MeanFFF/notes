package zuo.basesort;

import java.util.Arrays;

/**
 * @author gangpign.liu
 * @date 20210115
 */
public class SelectionSort {

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        /*
        找出0~N-1中最小值，与0位置的数交换
        找出1~N-1中最小值，与1位置的数交换
        找出2~N-1中最小值，与2位置的数交换
        ...
        找出N-2~N-1中最小值，与N-2位置的数交换
         */
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            CommonUtils.swap(arr, i, minIdx);
        }
    }

    public static void main(String[] args) {
        int testTimes = 500000;
        int maxSize = 100;
        int maxValue = 100;

        for (int k = 0; k < testTimes; k++) {
            int[] arr1 = CommonUtils.generateRandomArray(maxSize, maxValue);
            int[] arr2 = CommonUtils.copyOf(arr1);
            selectionSort(arr1);
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