package org.github.fourth.leetcode;

/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class LeetCode_123_maxProfit {
    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    public int maxProfit(int[] prices) {
        return new LeetCode_188_maxProfit()
                .maxProfitExample(2, prices);
    }
}
