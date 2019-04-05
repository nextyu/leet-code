package com.nextyu.leetcode._003_Longest_Substring_Without_Repeating_Characters;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * "abcabcbb"
 * 把字符串所有的组合列举出来，一个一个判断
 */
public class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            // i = 0 第一次循环

            // ---

            // i = 1 第二次循环
            for (int j = i + 1; j <= n; j++) {
                // j = 1    0,1 "ab"
                // j = 2    0,2 "abc"
                // j = 3    0,3 "abca"
                // ...
                // j = 8    0,8 "abcabcbb"

                // ---

                // j = 2    1,2 "bc"
                // j = 3    1,3 "bca"
                // j = 4    1,4 "bcab"
                // ...
                // j = 8    1,8 "bcabcbb"
                if (allUnique(s, i, j)) {
                    ans = Math.max(ans, j - i);
                }
            }
        }
        return ans;
    }

    public boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }

    @Test
    public void test1() {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("abcdabcbb"));
        System.out.println(lengthOfLongestSubstring("aaaaaaa"));
    }
}
