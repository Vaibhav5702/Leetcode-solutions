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
    int count=0,kSmall=0;
    public int kthSmallest(TreeNode root, int k) {
        getSmall(root,k);
        return kSmall;
    }
    public void getSmall(TreeNode root,int k)
    {
        if(root==null)
            return;
        getSmall(root.left,k);
        count++;
        if(count==k)
        {
            kSmall=root.val;
            return;
        }
        getSmall(root.right,k);
    }
}