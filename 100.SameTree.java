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
  public boolean isSameTree(TreeNode p, TreeNode q) {
    // if both nodes are null, they are the same
    if (p == null && q == null) {
      return true;
    }

    // if only one node is null, they are not the same
    if (p == null || q == null) {
      return false;
    }

    // if node values are different, they are not the same
    if (p.val != q.val) {
      return false;
    }

    // recursively check left and right subtrees
    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }
}