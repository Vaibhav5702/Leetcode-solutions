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
    public List<TreeNode> allPossibleFBT(int n) {
        if(n%2==0)
            return new ArrayList<>();
        List<List<TreeNode>> list=new ArrayList();
        list.add(new ArrayList<>());
        List<TreeNode> one=new ArrayList();
        one.add(new TreeNode(0));
        list.add(one);
        for(int i=2;i<=n;i++)
        {
            if(i%2==0)
            {
                list.add(new ArrayList<>());
                continue;
            }
            List<TreeNode> treeList=new ArrayList();
            for(int j=1;j<i;j+=2)
            {
                
                for(TreeNode left:list.get(j))
                {
                    for(TreeNode right:list.get(i-j-1))
                    {
                        TreeNode root=new TreeNode(0);
                        root.left=left;
                        root.right=right;
                        treeList.add(root);
                    }
                }
            }
            list.add(treeList);
            
        }
        return list.get(n);
    }
}