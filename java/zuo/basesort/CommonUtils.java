package zuo.basesort;

/**
 * @author gangping.liu
 * @date 20210119
 */
public class CommonUtils {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static boolean isEqual(int[] arr1, int[] arr2) {
        boolean check = (arr1 == null && arr2 != null) || (arr1 != null && arr2 == null);
        if (check) {
            return false;
        }

        if (arr1 == null) {
            return true;
        }

        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static int[] copyOf(int[] arr1) {
        int[] arr = new int[arr1.length];
        System.arraycopy(arr1, 0, arr, 0, arr1.length);
        return arr;
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) (Math.random() * maxSize)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * maxValue);
        }
        return arr;
    }

}
