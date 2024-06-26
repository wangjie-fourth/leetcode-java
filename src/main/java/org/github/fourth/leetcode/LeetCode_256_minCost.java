package org.github.fourth.leetcode;

import java.util.Arrays;

/**
 * 假如有一排房子，共 n 个，每个房子可以被粉刷成红色、蓝色或者绿色这三种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。
 * 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个 n x 3 的正整数矩阵 costs 来表示的。
 * 例如，costs[0][0] 表示第 0 号房子粉刷成红色的成本花费；costs[1][2] 表示第 1 号房子粉刷成绿色的花费，以此类推。
 * 请计算出粉刷完所有房子最少的花费成本。
 * 4步设计动态规划：
 * （1）定义状态：dp[n][3]: dp[n][0]表示第0号房子粉刷红色的整体最低成本；
 * （2）状态转移：
 * - dp[n][0] = min(dp[n - 1][1] + cost[n][0], dp[n - 1][2] + cost[n][0])
 * - dp[n][1] = min(dp[n - 1][0] + cost[n][1], dp[n - 1][2] + cost[n][1])
 * - dp[n][2] = min(dp[n - 1][0] + cost[n][2], dp[n - 1][1] + cost[n][2])
 * （3）初始状态：dp[0][0] = cost[0][0], dp[0][1] = cost[0][1], dp[0][2] = cost[0][2]
 * （4）求最优解：min(dp[n][0], dp[n][1], dp[n][2])
 */
public class LeetCode_256_minCost {
    /**
     *
     */
    public int minCost01(int[][] costs) {
        if (costs == null || costs[0].length == 0) {
            return -1;
        }
        int[][] dp = new int[costs.length][3];
        for (int i = 0; i < costs.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        int result = Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
        for (int i = 1; i < costs.length; i++) {
            dp[i][0] = Math.min(dp[i - 1][1] + costs[i][0], dp[i - 1][2] + costs[i][0]);
            dp[i][1] = Math.min(dp[i - 1][0] + costs[i][1], dp[i - 1][2] + costs[i][1]);
            dp[i][2] = Math.min(dp[i - 1][0] + costs[i][2], dp[i - 1][1] + costs[i][2]);
            result = Math.min(dp[i][0], Math.min(dp[i][1], dp[i][2]));
        }
        return result;
    }


    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    public int minCostExample(int[][] costs) {
        if (costs == null || costs.length == 0
                || costs[0] == null || costs[0].length == 0) {
            return 0;
        }

        int n = costs.length;
        // state：dp[i][k]：代表用颜色k粉刷第i个房子的最小花费
        int[][] dp = new int[2][3];
        Arrays.fill(dp[0], Integer.MAX_VALUE);
        Arrays.fill(dp[1], Integer.MAX_VALUE);

        // condition
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        // function: dp[i][k] = min(dp[i][k], dp[i-1][j](j != k) + costs[i][k])
        for (int i = 1; i < n; i++) {
            for (int k = 0; k < 3; k++) {
                for (int j = 0; j < 3; j++) {
                    if (j != k) {
                        dp[i % 2][k] = Math.min(dp[i % 2][k], dp[(i - 1) % 2][j] + costs[i][k]);
                    }
                }
            }
        }

        // solution: min(dp[n-1][0], dp[n-1][1], dp[n-1][2])
        return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
    }

}
