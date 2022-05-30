/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode lca;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p,q);
        return lca;
    }
    public boolean dfs(TreeNode root,TreeNode p,TreeNode q)
    {
        
        if(root==null)
            return false;
        int left=dfs(root.left,p,q)?1:0;
        int right=dfs(root.right,p,q)?1:0;
        int mid=((root==p)||(root==q))?1:0;
        if(mid+left+right>=2)
        {
            lca=root;
        }
        return mid+left+right>0;
    }
}