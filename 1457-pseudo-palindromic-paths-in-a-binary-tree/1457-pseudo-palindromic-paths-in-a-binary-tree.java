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
    public int pseudoPalindromicPaths (TreeNode root) {
        int freq[]=new int[10];
        return count(root,freq);
    }
    public int count(TreeNode root,int[] freq)
    {
        if(root.left==null&&root.right==null)
        {
            freq[root.val]++;
            int odd=0;
            for(int i=0;i<10;i++)
            {
                if(freq[i]%2!=0)
                    odd++;
            }
            freq[root.val]--;
            return odd>1?0:1;
        }
        freq[root.val]++;
        int sum=0;
        if(root.left!=null)
            sum+=count(root.left,freq);
        if(root.right!=null)
            sum+=count(root.right,freq);
        freq[root.val]--;
        return sum;
    }
}