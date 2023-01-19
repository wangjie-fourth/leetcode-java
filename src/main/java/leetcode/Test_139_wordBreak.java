package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jwang55
 */
public class Test_139_wordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null) {
            return false;
        }
        // 去除重复字典
        Set<String> set = new HashSet<>(wordDict);
        // 以i为index开头的字符串是否能成功分割在dict中找到相关单词
        // -1 : 初始化， 0 ： false， 1：true
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);

        return helper(memo, set, s, 0);
    }

    private boolean helper(int[] memo, Set<String> set, String s, int pos) {
        // 递归何时退出？
        // 单一解集如何能加入到解集？
        if (pos == s.length()) {
            return true;
        }
        if (memo[pos] != -1) {
            return memo[pos] == 1;
        }

        for (int i = s.length() - 1; i >= pos; i--) {
            String subString = s.substring(pos, i + 1);
            if (!set.contains(subString)) {
                continue;
            }
            boolean curSatisfy = helper(memo, set, s, i + 1);
            if (curSatisfy) {
                memo[pos] = 1;
                return true;
            }
        }
//        for (int i = pos; i < s.length(); i++) {
//            String subString = s.substring(pos, i + 1);
//            if (!wordDict.contains(subString)) {
//                continue;
//            }
//            boolean curSatisfy = helper(memo, wordDict, s, i + 1);
//            if (curSatisfy) {
//                return true;
//            }
//        }
        memo[pos] = 0;
        return false;
    }
}