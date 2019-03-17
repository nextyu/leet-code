package com.nextyu.leetcode._0001_two_sum;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int[] twoSumApproach1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] twoSumApproach3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    @Test
    public void test1() {
        int[] nums = {2, 7, 11, 15};
        int target = 17;
        int[] res = twoSumApproach3(nums, target);
        System.out.println(Arrays.toString(res));

        // 第1次循环 map.put 2->0
        // 第2次循环 map.put 7->1
        // 第3次循环 map.put 11->2
        // 第4次循环 complement = 2，map.get(complement) -> 0
    }
}
