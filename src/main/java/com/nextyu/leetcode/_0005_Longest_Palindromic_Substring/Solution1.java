package com.nextyu.leetcode._0005_Longest_Palindromic_Substring;

import org.junit.Test;

public class Solution1 {
    // “回文串”是一个正读和反读都一样的字符串，比如“level”或者“noon”等等就是回文串。
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int n = s.length();
        if (n == 1) {
            return s;
        }

        String str = "";
        // 暴力枚举每一种字符串组合
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String substring = s.substring(i, j);
//                System.out.println(substring);
                if (isPalindrome(substring) && substring.length() > str.length()) {
                    str = substring;
                }
            }
        }

        return str;
    }

    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        return s.equals(sb.reverse().toString());
    }

    @Test
    public void test1() {
        System.out.println(longestPalindrome("abacabcabb"));
        System.out.println(longestPalindrome("a"));
    }
}
