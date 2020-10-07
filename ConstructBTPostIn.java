
//Check base case
//1. Make a TreeNode from last element from postorder
//2. Find the index of the root node from inorder 
//3. Calculate post_left, post_right, in_left, in_right
//4. Call buildTree for root.left and root.right and pass above parameters

// Time Complexity : O(n) where n is the number of nodes in preoder and inorder array
// Space Complexity : O(max depth of tree) Recursive Stack. Here O(n+m) is not the space complexity because at a time there will be only one side in stack either left or right
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

import java.util.*;

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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0)
            return null;
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        int index = -1;

        for (int i = 0; i < inorder.length; i++) {
            if (root.val == inorder[i]) {
                index = i;
                break;
            }
        }

        int[] post_left = Arrays.copyOfRange(postorder, 0, index);
        int[] post_right = Arrays.copyOfRange(postorder, index, postorder.length - 1);
        int[] inorder_left = Arrays.copyOfRange(inorder, 0, index);
        int[] inorder_right = Arrays.copyOfRange(inorder, index + 1, postorder.length);

        root.left = buildTree(inorder_left, post_left);
        root.right = buildTree(inorder_right, post_right);

        return root;
    }
}