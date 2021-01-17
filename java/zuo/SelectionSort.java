package zuo;

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
            swap(arr, i, minIdx);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 3, 2, 5, 1, 4, 6, 8};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}