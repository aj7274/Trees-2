//1. Have a GlobalSum
//2. Call recursive function pass currSumm
//3. Recursive function: check base case
//4. check if left and right is null : compute global sum and curr sum
//5. Have Branch Sum 
//6. Call recurrsion on left and right of root
//return GlobalSum

// Time Complexity : O(n+m) where n is the nodes and m is the edges 
// Space Complexity : O(max depth of tree) Recursive Stack. 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No
class Solution {
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int globalSum = 0;

    public int sumNumbers(TreeNode root) {
        recurr(root, 0);
        return globalSum;
    }

    private void recurr(TreeNode root, int currSum) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            currSum += root.val;
            globalSum += currSum;
        }

        int branchSum = (currSum + root.val) * 10;

        recurr(root.left, branchSum);
        recurr(root.right, branchSum);
    }
}