package org.github.fourth.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * 回文串 是正着读和反着读都一样的字符串。
 */
public class LeetCode_131_partition {
    /**
     * 回溯法
     * 时间复杂度：
     * 空间复杂度：
     */
    public List<List<String>> partition01(String s) {
        // 解集
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.isEmpty()) {
            return result;
        }

        // 单一解集
        List<String> list = new ArrayList<>();
        // 递归遍历解空间树
        helper(result, list, s, 0);
        return result;
    }

    private void helper(List<List<String>> result, List<String> list, String s, int pos) {
        // 1. 递归什么时候结束？ pos为s的长度时
        // 2. 单一解集什么时候加入解集？
        if (pos == s.length()) {
            result.add(new ArrayList<>(list));
            return;
        }

        // 3. 分解解空间树的条件
        for (int i = pos; i < s.length(); i++) {
            // 如果当前字符不是对称的话，就不需要递归求解了
            String currentItem = s.substring(pos, i + 1);
            if (!judgeIsPartition(currentItem)) {
                continue;
            }
            // 3.1 扩展当前解集
            list.add(currentItem);
            // 3.2 递归求解解集
            helper(result, list, s, i + 1);
            // 3.3 回溯
            list.remove(list.size() - 1);
        }
    }

    private boolean judgeIsPartition(String currentItem) {
        if (currentItem == null || currentItem.isEmpty()) {
            return false;
        }
        char[] charArray = currentItem.toCharArray();
        if (charArray.length == 1) {
            return true;
        }
        for (int i = 0; i < charArray.length / 2; i++) {
            if (charArray[i] != charArray[charArray.length - i - 1]) {
                return false;
            }
        }
        return true;
    }


    private boolean[][] isPalindrome;

    /**
     * 时间复杂度：
     * 空间复杂度：
     * note:
     * 1. 记忆化搜索
     * 2. 直接返回解集
     */
    public List<List<String>> partitionExample(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        calculateIsPalindrome(s);
        /*
         * key: pos index
         * value: 切割方案
         */
        Map<Integer, List<List<String>>> memo = new HashMap<>();
        // 单一解集
        List<String> list = new ArrayList<>();

        return helperExample(memo, list, s, 0);
    }

    private List<List<String>> helperExample(Map<Integer, List<List<String>>> memo, List<String> list, String s, int pos) {
        // 递归何时退出？单一解集何时加入解集中？pos位于最后的值
        if (pos == s.length()) {
            List<List<String>> result = new ArrayList<>();
            result.add(list);
            return result;
        }

        if (memo.containsKey(pos)) {
            return memo.get(pos);
        }

        // 当前字符串符合要求的解集
        List<List<String>> result = new ArrayList<>();
        memo.put(pos, result);
        // 将问题拆分成子问题
        for (int i = pos; i < s.length(); i++) {
            String substring = s.substring(pos, i + 1);
            // 判断item是不是回文串
            if (!isPalindrome[pos][i]) {
                continue;
            }
            list.add(substring);

            List<List<String>> next = helperExample(memo, list, s, i + 1);
            for (List<String> item : next) {
                List<String> singleResult = new ArrayList<>();
                singleResult.add(substring);
                singleResult.addAll(item);
                memo.get(pos).add(singleResult);
            }
        }
        return memo.get(pos);
    }

    // 记忆化搜索，预处理
    private void calculateIsPalindrome(String s) {
        isPalindrome = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            isPalindrome[i][i] = true;
        }
        for (int i = 0; i < s.length(); i++) {
            isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }
        for (int i = s.length() - 3; i >= 0; i--) {
            for (int j = i + 2; j < s.length(); j++) {
                isPalindrome[i][j] = (isPalindrome[i + 1][j - 1] && s.charAt(i) == s.charAt(j));
            }
        }
    }

}
