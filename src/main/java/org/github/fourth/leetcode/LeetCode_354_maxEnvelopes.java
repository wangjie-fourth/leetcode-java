package org.github.fourth.leetcode;

import java.util.Arrays;

/**
 * 给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
 * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 * 注意：不允许旋转信封。
 */
public class LeetCode_354_maxEnvelopes {

    /**
     *
     */
    public int maxEnvelopes01(int[][] envelopes) {
        return 0;
    }

    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    public int maxEnvelopesExample(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0 || envelopes[0] == null
                || envelopes[0].length == 0) {
            return 0;
        }
        // 把二维问题转换为一维LIS => 排序
        // 排序：对w排序，若w相同，优先选择h高的（举例子来想）
        Arrays.sort(envelopes, (int[] a, int[] b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        // 对h做LIS
        int[] h = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            h[i] = envelopes[i][1];
        }

        // 对高进行LIS
        return lengthOfLIS(h);
    }

    /**
     * 动态规划、制表法找function
     * 时间复杂度：
     * 空间复杂度：
     */
    private int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // state：dp[i] ：以nums[i]结尾的最长严格递增子序列的长度
        // 由于最终要遍历dp数组取最长严格递增子序列的长度，所以无法状态压缩，不能用滚动数组
        int[] dp = new int[nums.length];

        // condition：每个以nums[i]结尾的最长严格递增子序列的最小长度至少为1
        Arrays.fill(dp, 1);

        // function：制表法得到递归函数表达式
        for (int i = 0; i < nums.length; i++) {
            // 遍历找之前结尾比nums[i]小的递增子序列，然后找到其中最长的
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // solution：遍历dp数组计算结果
        int result = 0;
        for (int value : dp) {
            result = Math.max(result, value);
        }
        return result;
    }
}
