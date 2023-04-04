/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
  public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    // If the subroot is null, it is a subtree of any tree
    if (subRoot == null) {
      return true;
    }    

    // If the root is null, there can be no subtree
    if (root == null) {
      return false;
    }

    // If the current nodes have the same value, check if the subtrees are the same
    if (root.val == subRoot.val && isSameTree(root, subRoot)) {
      return true;
    }

    // Check if the subroot is a subtree of the left or right subtree of root
    return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
  }

  public boolean isSameTree(TreeNode p, TreeNode q) {
    // If both trees are empty, they are the same
    if (p == null && q == null) {
      return true;
    }

    // If one of the trees is empty but the other is not, they are not the same
    if (p == null || q == null) {
      return false;
    }

    // If the current nodes have different values, they are not the same
    if (p.val != q.val) {
      return false;
    }

    // Check if the left and right subtrees are the same
    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }
}