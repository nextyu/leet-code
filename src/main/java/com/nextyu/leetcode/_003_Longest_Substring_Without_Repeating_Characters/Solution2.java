package com.nextyu.leetcode._003_Longest_Substring_Without_Repeating_Characters;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Sliding Window
 *
 * "abcabcbb"
 */
public class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0, i = 0, j = 0;
        Set<Character> set = new HashSet<>();
        while (i < n && j < n) {
            // i = 0, j = 0, set = []
            // i = 0, j = 1, set = [a]
            // i = 0, j = 2, set = [a,b]
            // i = 0, j = 3, set = [a,b,c]
            // i = 1, j = 3, set = [b,c]
            // i = 1, j = 4, set = [b,c,a]

            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }


    @Test
    public void test1() {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("abcdabcbb"));
        System.out.println(lengthOfLongestSubstring("aaaaaaa"));
        System.out.println(lengthOfLongestSubstring("a"));
    }
}
