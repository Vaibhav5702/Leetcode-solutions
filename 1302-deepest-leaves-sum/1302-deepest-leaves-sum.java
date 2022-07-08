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
    int maxDepth,sum;
    public int deepestLeavesSum(TreeNode root) {
        maxDepth=0;
        sum=0;
        dfs(root,0);
        return sum;
    }
    public void dfs(TreeNode root,int depth)
    {
        if(root.left==null&&root.right==null)
        {
            if(depth>maxDepth)
            {
                maxDepth=depth;
                sum=root.val;
            }
            else if(depth==maxDepth)
            {
                sum+=root.val;
            }
            return;
        }
        if(root.left!=null)
        dfs(root.left,depth+1);
        if(root.right!=null)
        dfs(root.right,depth+1);
    }
}