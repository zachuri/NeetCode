import javax.swing.tree.TreeNode;

// Easier to understand solution but slower

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
  private int height(TreeNode root) {
    if (root == null) {
      return 0;
    }

    return 1 + Math.max(height(root.left), height(root.right));
  }

  public int diameterOfBinaryTree(TreeNode root) {
    if (root == null) {
      return 0; 
    }

    int leftHeight = height(root.left);
    int rightHeight = height(root.right);

    int leftDiameter = diameterOfBinaryTree(root.left);
    int rightDiameter = diameterOfBinaryTree(root.right);

    return Math.max(leftHeight + rightHeight, Math.max(leftDiameter, rightDiameter));
  }
}


// Faster Solution

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
  public int diameterOfBinaryTree(TreeNode root) {
    // Store value of diameter -> is able to change within the function
    int[] diameter = {0};
    dfs(root, diameter);
    return diameter[0];
  }

  public int dfs(TreeNode root, int[] diameter) {
    // Base case
    if (root == null) {
      return 0;
    }

    // traverse through left and right
    int leftDiameter = dfs(root.left, diameter);
    int rightDiameter = dfs(root.right, diameter);

    // Obtain the diameter
    diameter[0] = Math.max(leftDiameter + rightDiameter, diameter[0]);

    // Traverse through left or right with greater height
    return Math.max(leftDiameter ,rightDiameter) + 1;
  }
}
