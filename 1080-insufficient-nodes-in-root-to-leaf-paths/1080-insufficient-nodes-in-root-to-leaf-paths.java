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
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if(!check(root,0,limit))
            return null;
        else
            return root;
    }
    public boolean check(TreeNode root, int sum,int limit)
    {
        if(root.left==null&&root.right==null)
            return sum+root.val>=limit;
        boolean l=false,r=false;
        if(root.left!=null)
            l=check(root.left,sum+root.val,limit);
        if(!l)
            root.left=null;
        if(root.right!=null)
            r=check(root.right,sum+root.val,limit);
        if(!r)
            root.right=null;
        return l|r;
            
    }
}