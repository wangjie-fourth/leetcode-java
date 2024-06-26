package org.github.fourth.leetcode;

import org.github.fourth.leetcode.common.TreeNode;

/**
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 */
public class LeetCode_100_isSameTree {
    /**
     * 分治法
     * 时间复杂度：
     * 空间复杂度：
     */
    public boolean isSameTree01(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        // Divide
        boolean leftSameTree = isSameTree01(p.left, q.left);
        boolean rightSameTree = isSameTree01(p.right, q.right);

        // Combine
        return leftSameTree && rightSameTree && p.val == q.val;
    }

    public boolean isSameTree02(TreeNode p, TreeNode q) {
        return false;
    }
}
