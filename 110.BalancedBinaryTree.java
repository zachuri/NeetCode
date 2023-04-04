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
	// get the height
  public int getHeight(TreeNode root) {
    if (root == null) {
      return 0;
    } 

    return 1 + Math.max(getHeight(root.left), getHeight(root.right));
  }

	// 
  public boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }   

    int leftHeight = getHeight(root.left);
    int rightHeight = getHeight(root.right);

		// check if left and right difference height > 1
    if (Math.abs(leftHeight - rightHeight) > 1) {
      return false;
    }

    return isBalanced(root.left) && isBalanced(root.right);
  }
}