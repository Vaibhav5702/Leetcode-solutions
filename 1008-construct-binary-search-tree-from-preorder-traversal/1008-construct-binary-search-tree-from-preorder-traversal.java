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
    int idx;
    public TreeNode bstFromPreorder(int[] preorder) {
        idx=0;
        int inorder[]=preorder.clone();
        Arrays.sort(inorder);
        return createTree(0,inorder.length-1,preorder,inorder);
    }
    public TreeNode createTree(int l,int h, int[] pre,int[] in)
    {
        if(l>h)
            return null;
        TreeNode root=new TreeNode(pre[idx]);
        int index=search(in,pre[idx++]);
        root.left=createTree(l,index-1,pre,in);
        root.right=createTree(index+1,h,pre,in);
        return root;
    }
    public int search(int arr[],int val)
    {
        int low=0,high=arr.length-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(arr[mid]==val)
                return mid;
            else if(arr[mid]<val)
                low=mid+1;
            else
                high=mid-1;
        }
        return -1;
    }
}