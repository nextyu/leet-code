package com.nextyu.leetcode._003_Longest_Substring_Without_Repeating_Characters;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Sliding Window
 * <p>
 * "abcabcbb"
 */
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j < n; j++) {

            // i = 0, j = 0, map = []
            // i = 0, j = 1, map = {a->1}
            // i = 0, j = 2, map = {a->1, b->2}
            // i = 0, j = 3, map = {a->1, b->2, c->3}
            // i = 1, j = 4, map = {a->4, b->2, c->3}
            // i = 2, j = 5, map = {a->4, b->5, c->3}
            // i = 3, j = 6, map = {a->4, b->5, c->6}

            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;


        // 取上次重复字母出现的地方，计算长度

        // [abca]bcbb
        // a[bcab]cbb
        // ab[cabc]bb
        // abca[bcb]b
        // abcabc[bb]

    }


    @Test
    public void test1() {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(lengthOfLongestSubstring("abcdabcbb"));
//        System.out.println(lengthOfLongestSubstring("aaaaaaa"));
//        System.out.println(lengthOfLongestSubstring("a"));
    }
}
