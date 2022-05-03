class Solution {
    public int findUnsortedSubarray(int[] nums) {
        Stack<Integer> stack=new Stack();
        int l=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            if(stack.isEmpty()||nums[i]>=stack.peek())
            {
                stack.push(nums[i]);
                continue;
            }
            while(!stack.isEmpty()&&nums[i]<stack.peek())
            {
                stack.pop();
            }
            l=Math.min(l,stack.size());
            stack.push(nums[i]);
        }
        stack=new Stack();
        int r=Integer.MIN_VALUE;
        for(int i=nums.length-1;i>=0;i--)
        {
            if(stack.isEmpty()||nums[i]<=stack.peek())
            {
                stack.push(nums[i]);
                continue;
            }
            while(!stack.isEmpty()&&nums[i]>stack.peek())
                stack.pop();
            r=Math.max(r,nums.length-stack.size()-1);
            stack.push(nums[i]);
        }
        return l>=r?0:r-l+1;
    }
}