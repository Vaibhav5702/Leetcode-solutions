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
    public int sumNumbers(TreeNode root) {
        return findSum(root,0);
    }
    public int findSum(TreeNode root,int sum)
    {
        if(root==null||(root.left==null&&root.right==null))
            return sum*10+root.val;
        sum=sum*10+root.val;
        int total=0;
        if(root.left!=null)
            total+=findSum(root.left,sum);
        if(root.right!=null)
            total+=findSum(root.right,sum);
        return total;
    }
}