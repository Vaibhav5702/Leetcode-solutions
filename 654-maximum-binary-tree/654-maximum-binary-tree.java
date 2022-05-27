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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root=buildTree(0,nums.length-1,nums);
        return root;
    }
    public TreeNode buildTree(int left,int right,int[] nums)
    {
        if(left>right)
            return null;
        int max=-1,index=-1;
        for(int i=left;i<=right;i++)
        {
            if(nums[i]>max)
            {
                max=nums[i];
                index=i;
            }
        }
        TreeNode root=new TreeNode(max);
        root.left=buildTree(left,index-1,nums);
        root.right=buildTree(index+1,right,nums);
        return root; 
    }
}