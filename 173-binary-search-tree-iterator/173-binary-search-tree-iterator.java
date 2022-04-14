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
class BSTIterator {

    List<Integer> list;
    int index;
    public BSTIterator(TreeNode root) {
        list=new ArrayList();
        index=0;
        fillList(root);
    }
    
    public int next() {
        return list.get(index++);
    }
    
    public boolean hasNext() {
        if(index==list.size())
            return false;
        return true;
    }
    public void fillList(TreeNode root)
    {
        if(root==null)
            return;
        fillList(root.left);
        list.add(root.val);
        fillList(root.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */