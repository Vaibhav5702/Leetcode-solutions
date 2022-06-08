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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1=new ArrayList();
        List<Integer> list2=new ArrayList();
        List<Integer> ans=new ArrayList();
        dfs(root1,list1);
        dfs(root2,list2);
        int i=0,j=0;
        while(i<list1.size()&&j<list2.size())
        {
            if(list1.get(i)<list2.get(j))
                ans.add(list1.get(i++));
            else
                ans.add(list2.get(j++));
        }
        while(i<list1.size())
        {
            ans.add(list1.get(i++));
        }
        while(j<list2.size())
        {
            ans.add(list2.get(j++));
        }
        return ans;
    }
    public void dfs(TreeNode root,List<Integer> list)
    {
        if(root==null)
        {
            return;
        }
        dfs(root.left,list);
        list.add(root.val);
        dfs(root.right,list);
    }
}