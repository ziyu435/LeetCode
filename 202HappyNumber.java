import java.util.HashSet;
import java.util.Set;

public class Solution {

    public boolean isHappy(int n) {
        Set<Integer> nextSet = new HashSet<Integer>();
        while(n != 1 && !nextSet.contains(n)) {
            nextSet.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    private int getNext(int n) {
        int totalSum = 0;
        while(n > 0) {
            totalSum += (n % 10) * (n % 10);
            n /= 10;
        }
        return totalSum;
    }
}

/**
 * Hint:
 * Step1: Calculate the next number given the number n.
 * Step2: Determine if the next number has entered a cycle.
 *
 * Why HashSet:
 * We have to repeatedly check whether or not numbers are in the set.
 * Checking if a number is in HashSet takes O(1) time,
 * whereas for the other data structures like vector, list or array take O(n) time.
 * */
