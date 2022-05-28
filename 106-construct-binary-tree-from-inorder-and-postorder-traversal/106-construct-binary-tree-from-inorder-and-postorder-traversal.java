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
    int pIndex;
    public TreeNode buildTree(int[] inOrder, int[] postOrder) {
        pIndex=inOrder.length-1;
        return getTree(0,inOrder.length-1,inOrder,postOrder);
    }
    public TreeNode getTree(int left,int right,int[] in,int[] post)
    {
        if(left>right)
            return null;
        int index=0;
        for(int i=right;i>=left;i--)
        {
            if(post[pIndex]==in[i])
            {
                index=i;
                break;
            }
        }
        TreeNode root=new TreeNode(post[pIndex--]);
        root.right=getTree(index+1,right,in,post);
        root.left=getTree(left,index-1,in,post);
        return root;
    }
}