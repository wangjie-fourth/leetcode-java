package org.github.fourth.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 */
public class LeetCode_018_fourSum {
    /**
     * 转换成三数之和、二数之和
     * 时间复杂度：O(nlogn) + n*n*n = n^3
     * 空间复杂度：
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        // 因为返回值不需要下标，无脑排序一波
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            // 排除重复元素
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length - 2; j++) {
                // 排除重复元素
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int start = j + 1;
                int end = nums.length - 1;
                while (start < end) {
                    // note: 这里有int溢出的问题（好烦）
                    long sum = (long) nums[i] + nums[j] + nums[start] + nums[end];
                    if (sum == target) {
                        if (start > j + 1 && nums[start] == nums[start - 1]) {
                            start++;
                            continue;
                        }
                        if (end < nums.length - 1 && nums[end] == nums[end + 1]) {
                            end--;
                            continue;
                        }
                        result.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                        start++;
                        end--;
                    } else if (sum > target) {
                        end--;
                    } else {
                        start++;
                    }
                }
            }
        }
        return result;
    }

    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    public List<List<Integer>> fourSumExample(int[] nums, int target) {
        return fourSum(nums, target);
    }
}
