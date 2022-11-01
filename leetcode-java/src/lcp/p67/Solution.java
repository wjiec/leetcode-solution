package lcp.p67;

import common.Checker;
import common.TreeNode;

/**
 * LCP 67. 装饰树
 *
 * https://leetcode.cn/problems/KnLfVT/
 *
 * 力扣嘉年华上的 DIY 手工展位准备了一棵缩小版的 二叉 装饰树 root 和灯饰，你需要将灯饰逐一插入装饰树中，要求如下：
 *
 * 完成装饰的二叉树根结点与 root 的根结点值相同
 * 若一个节点拥有父节点，则在该节点和他的父节点之间插入一个灯饰（即插入一个值为 -1 的节点）。具体地：
 * 在一个 父节点 x 与其左子节点 y 之间添加 -1 节点， 节点 -1、节点 y 为各自父节点的左子节点，
 * 在一个 父节点 x 与其右子节点 y 之间添加 -1 节点， 节点 -1、节点 y 为各自父节点的右子节点，
 *
 * 现给定二叉树的根节点 root ，请返回完成装饰后的树的根节点。
 */

public class Solution {

    public TreeNode expandBinaryTree(TreeNode root) {
        if (root == null) return null;

        if (root.left != null) root.left = new TreeNode(-1, expandBinaryTree(root.left), null);
        if (root.right != null) root.right = new TreeNode(-1, null, expandBinaryTree(root.right));

        return root;
    }

    public static void main(String[] args) {
        assert Checker.check(new Solution().expandBinaryTree(TreeNode.build(7,5,6)), TreeNode.build(7,-1,-1,5,null,null,6));
        assert Checker.check(new Solution().expandBinaryTree(TreeNode.build(3,1,7,3,8,null,4)),
            TreeNode.build(3,-1,-1,1,null,null,7,-1,-1,null,-1,3,null,null,8,null,4));
    }

}
