public class Solution {
    public void moveZeroes(int[] nums) {

        // Maintain two pointers (fast-slow pointer)
        // firstZero: All elements before the slow pointer are non-zeros.
        // curr: Iterate through the curr. All elements between the fast and slow pointer are zeros.
        int firstZero = 0;  //
        for(int curr = 0; curr < nums.length; curr++) {
            if(nums[curr] != 0) {
                nums[firstZero++] = nums[curr];
            }
        }

        // Set the value with index equal or bigger than firstzero to 0.
        for(; firstZero < nums.length; firstZero++) {
            nums[firstZero] = 0;
        }
    }

    // Tips:
    // The slow pointer maintains the last non-zero position of the final array.
    // The fast pointer finds the first non-zero value after the slow pointer.
}
