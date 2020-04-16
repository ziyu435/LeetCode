public class Solution_left {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int p = nums1.length - 1;
        int p1 = m - 1, p2 = n - 1;

        while((p1 >= 0) && (p2 >= 0)) {
            nums1[p--] = (nums1[p1] > nums2[p2])? nums1[p1--]: nums2[p2--];
        }
        System.arraycopy(nums2, 0, nums1, 0, p2+1);

        // When all the nums2 items go to nums1, p2=-1
        // Then it copies nothing.
    }
}
