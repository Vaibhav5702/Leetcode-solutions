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
    public TreeNode convertBST(TreeNode root) {
        changeVal(root,0);
        return root;
    }
    public int changeVal(TreeNode root,int sum)
    {
        if(root==null)
        {
            return sum;
        }
        root.val=root.val+changeVal(root.right,sum);
        if(root.left!=null)
        {
            return changeVal(root.left,root.val);
        }
        return root.val;
    }
}