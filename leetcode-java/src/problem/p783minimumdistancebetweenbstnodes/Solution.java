package problem.p783minimumdistancebetweenbstnodes;

import common.TreeNode;

/**
 * 783. Minimum Distance Between BST Nodes
 *
 * https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
 *
 * Given the root of a Binary Search Tree (BST), return the minimum difference between
 * the values of any two different nodes in the tree.
 */

public class Solution {

    public int minDiffInBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return Integer.MAX_VALUE;
        }

        int v = Math.min(minDiffInBST(root.left), minDiffInBST(root.right));
        if (root.left != null) {
            v = Math.min(v, root.val - max(root.left));
        }
        if (root.right != null) {
            v = Math.min(v, min(root.right) - root.val);
        }

        return v;
    }

    private int min(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }

    private int max(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }

    public static void main(String[] args) {
        assert new Solution().minDiffInBST(TreeNode.build(236,104,701,null,227,null,911)) == 9;
        assert new Solution().minDiffInBST(TreeNode.build(4,2,6,1,3)) == 1;
        assert new Solution().minDiffInBST(TreeNode.build(1,0,48,null,null,12,49)) == 1;
    }

}
