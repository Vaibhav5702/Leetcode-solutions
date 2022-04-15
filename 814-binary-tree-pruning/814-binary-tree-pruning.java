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
    public TreeNode pruneTree(TreeNode root) {
        int numOnes=countOnes(root);
        if(numOnes==0)
            return null;
        return root;
    }
    public int countOnes(TreeNode root)
    {
        if(root==null)
            return 0;
        
        int left=countOnes(root.left);
        if(left==0)
            root.left=null;
        int right=countOnes(root.right);
        if(right==0)
            root.right=null;
        return root.val+left+right;
    }
}