class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack=new Stack();
        int[] min=new int[nums.length];
        min[0]=Integer.MAX_VALUE;
        for(int i=1;i<nums.length;i++)
        {
            min[i]=Math.min(min[i-1],nums[i-1]);
        }
        for(int i=nums.length-1;i>0;i--)
        {
            if(nums[i]>min[i])
            {
                while(!stack.isEmpty()&&stack.peek()<=min[i])
                {
                    stack.pop();
                }
                if(!stack.isEmpty()&&nums[i]>stack.peek())
                    return true;
                stack.push(nums[i]);
            }
        }
        return false;
    }
}