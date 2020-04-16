public class Solution {

    public int removeDuplicates(int[] nums) {

        // Fast-Slow pointer
        int unique = 0;
        for(int curr = 1; curr < nums.length; curr++) {
            if(nums[curr] != nums[unique]) {
                unique++;
                nums[unique] = nums[curr];
            }
        }
        return unique + 1;
    }

    // Maintain two pointers:
    // The unique maintain the last position of the final array of unique numbers.
    // The values of index between fast and slow pointers are the same.
}
