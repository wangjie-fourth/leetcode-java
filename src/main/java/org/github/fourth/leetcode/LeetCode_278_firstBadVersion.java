package org.github.fourth.leetcode;

/**
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 */
public class LeetCode_278_firstBadVersion extends VersionControl {

    public LeetCode_278_firstBadVersion(int badVersion) {
        super.badVersion = badVersion;
    }

    /**
     * 时间复杂度：O(logn)
     * 空间复杂度：O(1)
     */
    public int firstBadVersion(int n) {
        if (n <= 0) {
            return 0;
        }

        int start = 1;
        int end = n;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (super.isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (isBadVersion(start)) {
            return start;
        }
        if (isBadVersion(end)) {
            return end;
        }
        return 0;
    }


}

class VersionControl {
    public int badVersion;

    public boolean isBadVersion(int version) {
        return version >= badVersion;
    }

}

