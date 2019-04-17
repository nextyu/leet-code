package com.nextyu.leetcode._0007_Reverse_Integer;

import com.sun.org.apache.regexp.internal.RE;
import org.junit.Test;

/**
 * 整数反转
 */
public class Solution {
    public int reverse(int x) {
        /*
        //pop operation:
        pop = x % 10;
        x /= 10;

        //push operation:
        temp = rev * 10 + pop;
        rev = temp;
         */

        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;

            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }

            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }

            rev = rev * 10 + pop;
        }
        return rev;
    }

    @Test
    public void test1() {
        System.out.println(reverse(-7897));
        System.out.println(reverse(Integer.MAX_VALUE));

        System.out.println("-----------------");

        System.out.println(Integer.MAX_VALUE);
        System.out.println((int)Math.pow(2, 31));
        System.out.println(Integer.MIN_VALUE);
        System.out.println((int)Math.pow(-2, 31));

        long sum = 1;
        for (int i = 0; i < 31; i++) {
            sum *= 2;
        }
        System.out.println(sum);

        System.out.println(1<<31);
    }
}
