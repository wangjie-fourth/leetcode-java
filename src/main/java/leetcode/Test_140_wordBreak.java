package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jwang55
 */
public class Test_140_wordBreak {
    /* 记忆化搜索 */
    public List<String> wordBreak(String s, List<String> wordDict) {
        // 解集
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0 || wordDict == null) {
            return result;
        }
        // key 为要拆分的字符串开始的位置，value：可能的全部单词组合
        Map<Integer, List<String>> memo = new HashMap<>();

        return helper(memo, s, 0, wordDict);
    }


    private List<String> helper(Map<Integer, List<String>> memo, String s, int pos, List<String> wordDict) {
        // 先判断之前是否已经搜索过
        if (memo.containsKey(pos)) {
            return memo.get(pos);
        }
        // 当前字符串的结果集
        List<String> result = new ArrayList<>();

        // 递归什么时候退出？
        if (pos == s.length()) {
            return result;
        }

        // 单一解集什么时候加入解集中？
        if (wordDict.contains(s.substring(pos))) {
            result.add(s.substring(pos));
        }

        // 拆分子问题
        for (int i = pos; i < s.length(); i++) {
            String subString = s.substring(pos, i + 1);
            if (!wordDict.contains(subString)) {
                continue;
            }
            List<String> curResult = helper(memo, s, i + 1, wordDict);
            for (String item : curResult) {
                result.add(subString + " " + item);
            }
        }
        memo.put(pos, result);

        return result;
    }


    /* 回溯法 */
    public List<String> wordBreak01(String s, List<String> wordDict) {
        // 解集
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0 || wordDict == null) {
            return result;
        }
        // 单一解集
        List<String> list = new ArrayList<>();

        helper01(result, list, s, 0, wordDict);

        return result;
    }

    private void helper01(List<String> result, List<String> list, String s, int pos, List<String> wordDict) {
        // 递归什么时候退出？
        // 单一解集什么时候加入解集中？
        if (pos == s.length()) {
            result.add(String.join(" ", list));
            return;
        }

        // 拆分子问题
        for (int i = pos; i < s.length(); i++) {
            String subString = s.substring(pos, i + 1);
            if (!wordDict.contains(subString)) {
                continue;
            }
            list.add(subString);
            helper01(result, list, s, i + 1, wordDict);
            // 回溯
            list.remove(list.size() - 1);
        }
    }
}