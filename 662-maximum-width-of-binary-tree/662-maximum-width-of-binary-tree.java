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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> q1=new LinkedList();
        Queue<Integer> q2=new LinkedList();
        q1.offer(root);
        q2.offer(0);
        int maxWidth=0;
        while(!q1.isEmpty())
        {
            int width=q1.size();
            int l=q2.peek(),pos=l;
            for(int i=0;i<width;i++)
            {
                TreeNode node=q1.poll();
                pos=q2.poll()-l;
                if(node.left!=null){
                    q1.offer(node.left);
                    q2.offer(2*pos+1);
                }
                if(node.right!=null){
                    q1.offer(node.right);
                    q2.offer(2*pos+2);
                }
            }
            
            maxWidth=Math.max(maxWidth,pos+1);
        }
        return maxWidth;
    }
}