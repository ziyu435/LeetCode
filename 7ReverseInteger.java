public class Solution {
    public int reverse(int x) {
        int rev = 0;
        while(x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }
}

/**
 * Hint
 * pop最右边的，直接加到rev上，再让rev*10
 *
 * 关于pop>7,pop<08
 * 从正面想。。。
 * x > 0
 * Integer.MAX_VALUE=2^31-1以7结尾。rev只能取到十位以前的，个位的用pop补。
 * x < 0
 * Integer.MIN_VALUE=-2^31以8结尾。*/
