import java.util.Arrays;

public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] char_map = new int[26];
        for(char c: tasks) {
            char_map[c-'A']++;
        }
        Arrays.sort(char_map);
        int max_slot_group = char_map[25] - 1;
        // Assume the most frequent task is F. The the last F task doesn;t need to cool.
        int idle_slot = max_slot_group * n;
        for(int i = 24; i >= 0; i--) {
            idle_slot -= Math.min(char_map[i], max_slot_group);
        }
        return idle_slot > 0 ? tasks.length + idle_slot : tasks.length;
        // The check must be '>0'.
        // Or if n = 0, then the idle_slot < 0.
        // If we check idle_slot==0, then it the time interval we calculated would be less than the number of tasks.

        // Always check the situation when the parameter is zero.
    }
}
