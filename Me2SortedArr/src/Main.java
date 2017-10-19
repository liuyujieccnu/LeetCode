import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {1};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int[] arr = new int[len];
//        System.arraycopy(nums1, 0, arr, 0, nums1.length);
//        System.arraycopy(nums2, 0, arr, nums1.length, nums2.length);
//        Arrays.sort(arr);
        if (nums2.length != 0 && nums1.length != 0) {
            if (nums1[0] >= nums2[nums2.length - 1]) {
                arr = twoArrJoin(nums2, nums1);
            } else if (nums2[0] >= nums1[nums1.length - 1]) {
                arr = twoArrJoin(nums1, nums2);
            } else {
                arr = twoArrJoin(nums1, nums2);
                Arrays.sort(arr);
            }
        } else {
            arr = twoArrJoin(nums1, nums2);
        }

        double ans;
        if (len % 2 == 1) {
            ans = arr[(len - 1) / 2];
        } else {
            ans = (double) (arr[len / 2] + arr[(len / 2) - 1]) / 2;
        }
        return ans;
    }

    public static int[] twoArrJoin(int[] arr1, int[] arr2) {
        int[] arr = new int[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, arr, 0, arr1.length);
        System.arraycopy(arr2, 0, arr, arr1.length, arr2.length);
        return arr;
    }
}
