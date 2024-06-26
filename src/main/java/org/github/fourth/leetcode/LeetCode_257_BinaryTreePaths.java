package org.github.fourth.leetcode;


import org.github.fourth.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * 叶子节点 是指没有子节点的节点。
 */
public class LeetCode_257_BinaryTreePaths {

    /**
     * 回溯法
     * 时间复杂度：
     * 空间复杂度：
     */
    public List<String> binaryTreePaths01(TreeNode root) {
        // 解集
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        // 单一解集
        List<String> list = new ArrayList<>();
        list.add(String.valueOf(root.val));

        // 递归求解问题
        helper(result, list, root);
        return result;
    }

    private void helper(List<String> result, List<String> list, TreeNode root) {
        // 1. 递归什么时候结束？root为叶子节点时
        // 2. 单一解集什么时候加入解集？
        if (root.left == null && root.right == null) {
            result.add(String.join("->", list));
            return;
        }

        // 3. 拆分问题
        if (root.left != null) {
            list.add(String.valueOf(root.left.val));
            helper(result, list, root.left);
            // 回朔
            list.remove(list.size() - 1);
        }

        if (root.right != null) {
            list.add(String.valueOf(root.right.val));
            helper(result, list, root.right);
            list.remove(list.size() - 1);
        }
    }

    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    public List<String> binaryTreePathsExample(TreeNode root) {
        // 解集
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // 单一解集
        List<String> list = new ArrayList<>();
        list.add(String.valueOf(root.val));

        helperExample(result, list, root);

        return result;
    }

    public void helperExample(List<String> result, List<String> sb, TreeNode root) {
        // 递归何时退出：到达叶子节点
        if (root == null || (root.left == null && root.right == null)) {
            result.add(String.join("->", sb));
            return;
        }

        if (root.left != null) {
            sb.add(String.valueOf(root.left.val));
            helperExample(result, sb, root.left);
            // 回朔
            sb.remove(sb.size() - 1);
        }

        if (root.right != null) {
            sb.add(String.valueOf(root.right.val));
            helperExample(result, sb, root.right);
            sb.remove(sb.size() - 1);
        }
    }
}
