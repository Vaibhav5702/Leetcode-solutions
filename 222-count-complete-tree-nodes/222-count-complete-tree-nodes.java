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
    int count=0;
    public int countNodes(TreeNode root) {
        if(root==null)
            return 0;
        int depth=0;
        TreeNode temp=root;
        while(temp!=null)
        {
            temp=temp.left;
            depth++;
        }
        dfs(root,depth);
        return ((int)Math.pow(2,depth-1)-1)+count/2;
    }
    public boolean dfs(TreeNode root,int depth)
    {
        if(root==null)
        {
            if(depth==1)
                return true;
            else
            {
                count++;
                return false;
            }
        }
        if(dfs(root.left,depth-1))
            return true;
        if(dfs(root.right,depth-1))
            return true;
        return false;
        
    }
}