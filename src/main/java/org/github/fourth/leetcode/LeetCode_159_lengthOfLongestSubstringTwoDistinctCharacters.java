package org.github.fourth.leetcode;

import java.util.HashMap;
import java.util.Map;
/**
 * 给你一个字符串 s ，请你找出 至多 包含 两个不同字符 的最长子串，并返回该子串的长度。
 */
public class LeetCode_159_lengthOfLongestSubstringTwoDistinctCharacters {

    /**
     *
     */
    public int lengthOfLongestSubstringTwoDistinctCharacters01(String s) {
        return 0;
    }

    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    public int lengthOfLongestSubstringTwoDistinctCharactersExample(String s) {
        int result = 0;
        if (s == null || s.length() == 0) {
            return result;
        }

        int i = 0;
        int j = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (i = 0; i < s.length(); i++) {
            while (j < s.length()) {
                char ch = s.charAt(j);
                if (map.size() < 2 || map.containsKey(ch)) {
                    map.put(ch, j);
                    result = Math.max(result, j - i + 1);
                    j++;
                } else {
                    break;
                }
            }
            // 收缩
            int minIndex = s.length() - 1;
            for (int index : map.values()) {
                minIndex = Math.min(minIndex, index);
            }
            char charToDelete = s.charAt(minIndex);
            map.remove(charToDelete);
            i = minIndex;
        }
        return result;
    }
}
