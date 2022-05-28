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
    int pIndex=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return getTree(0,preorder.length-1,preorder,inorder);
    }
    public TreeNode getTree(int left, int right,int[] pre,int[] in)
    {
        if(left>right)
            return null;
        int index=0;
        for(int i=left;i<=right;i++)
        {
            if(pre[pIndex]==in[i])
            {
                index=i;
                break;
            }
        }
        TreeNode root=new TreeNode(pre[pIndex++]);
        root.left=getTree(left,index-1,pre,in);
        root.right=getTree(index+1,right,pre,in);
        return root;
    }
}