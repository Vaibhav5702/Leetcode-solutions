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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1)
        {
            TreeNode newRoot=new TreeNode(val);
            newRoot.left=root;
            return newRoot;
        }
        // Queue<TreeNode> prev=new LinkedList();
        // Queue<TreeNode> next=new LinkedList();
        // next.offer(root);
        // int i=1;
        // while(!next.isEmpty()&&i!=depth)
        // {
        //     int size=next.size();
        //     prev=new LinkedList(next);
        //     i++;
        //     for(int j=0;j<size;j++)
        //     {
        //         TreeNode node=next.poll();
        //         if(node.left!=null)
        //         next.offer(node.left);
        //         if(node.right!=null)
        //         next.offer(node.right);
        //     }
        // }
        // System.out.println(prev);
        // return root;
        addVal(root,1,depth,val);
        return root;
    }
    public void addVal(TreeNode root,int i,int depth,int val)
    {
        if(i==depth-1)
        {
            TreeNode left=root.left;
            TreeNode right=root.right;
            TreeNode newLeft=new TreeNode(val);
            TreeNode newRight=new TreeNode(val);
            newLeft.left=left;
            newRight.right=right;
            root.left=newLeft;
            root.right=newRight;
            return;
        }
        if(root.left!=null)
            addVal(root.left,i+1,depth,val);
        if(root.right!=null)
            addVal(root.right,i+1,depth,val);
    }
}