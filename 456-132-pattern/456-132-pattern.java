class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack=new Stack();
        int[] min=new int[nums.length];
        stack.push(0);
        min[0]=Integer.MAX_VALUE;
        for(int i=1;i<nums.length;i++)
        {
            min[i]=Math.min(min[i-1],nums[i-1]);
            while(!stack.isEmpty()&&nums[stack.peek()]<=nums[i])
            {
                stack.pop();
            }
            if(!stack.isEmpty()&&nums[stack.peek()]>nums[i]&&min[stack.peek()]<nums[i])
                return true;
            stack.push(i);
        }
        return false;
    }
}