package com.nextyu.leetcode._005_Longest_Palindromic_Substring;

import org.junit.Test;

/**
 * 中心扩展法
 * 从左往右扫描字符串S，以每个字符为中心，向两边扩展构造回文子串，记录最长回文子串的起始结束位置。
 */
public class Solution2 {
    // “回文串”是一个正读和反读都一样的字符串，比如“level”或者“noon”等等就是回文串。
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int n = s.length();
        if (n == 1) {
            return s;
        }

        int start = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    @Test
    public void test1() {
        System.out.println(longestPalindrome("abacabcabb"));
        System.out.println(longestPalindrome("babad"));
        String s = "babad";
//        expandAroundCenter(s, 2, 2);
    }
}
