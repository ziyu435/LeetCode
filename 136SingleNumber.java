import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for(int n : nums) {
            if(numSet.contains(n)) {
                numSet.remove(n);
            } else {
                numSet.add(n);
            }
        }
        // There is only one element left in the current set.
        return numSet.iterator().next();
    }
}
