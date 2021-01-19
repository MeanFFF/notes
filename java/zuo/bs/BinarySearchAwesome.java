package zuo.bs;

import zuo.basesort.CommonUtils;

/**
 * @author gangping.liu
 * @date 20210119
 * 局部最小：
 * 1. arr[0] < arr[1] -> arr[0]是局部最小值
 * 2. arr[N] < arr[N-1] -> arr[N-1]是局部最小值
 * 3. arr[M-1] < arr[M] < arr[M+1] -> arr[M]是局部最小值
 *
 * 情况3可以用二分查找：
 * arr[0] arr[1] …… arr[N-1] arr[N]
 *       ↘       ……         ↗
 *         中间必定有局部最小值
 *
 */
public class BinarySearchAwesome {

    private static int binarySearchAwesome(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }

        int l = 1;
        int r = arr.length - 2;
        while (l <= r) {
            // 当arr[mid]大于两边时，选择一边就行了
            int mid = l + (r - l) / 2;
            if (arr[mid] > arr[mid - 1]) {
                r = mid - 1;
            } else if (arr[mid] > arr[mid + 1]){
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }


}
