public class Solution {
    public int[] sortedSquares(int[] A) {

        // Find the positive and negative number with the smallest absolute value
        // -4   -1    0    3    10
        //       p1   p2
        int i = 0;
        while(i < A.length && A[i] < 0) {
            i++;
        }
        int p1 = i - 1;   // the biggest negative number
        int p2 = i;       // the smallest non-negative number


        // Merge Two Sorted Array
        // -4       -1       0        3         10
        //     <--  p1       p2  -->
        //neagative array    non-negative array

        int j = 0;
        int[] Square = new int[A.length];
        while(p1 >= 0 && p2 < A.length) {
            if(A[p1] * A[p1] < A[p2] * A[p2]) {
                Square[j++] = A[p1] * A[p1];
                p1--;
            } else {
                Square[j++] = A[p2] * A[p2];
                p2++;
            }
        }

        // Either the negative or non-negative array would have left items
        // Add them to the Square.
        while(p1 >= 0) {
            Square[j++] = A[p1] * A[p1];
            p1--;
        }

        while(p2 < A.length) {
            Square[j++] = A[p2] * A[p2];
            p2++;
        }

        return Square;
    }
}
