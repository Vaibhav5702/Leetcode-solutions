class Solution {
    public int maxArea(int[] height) {
        int left=0,right=height.length-1;
        int cur=0,res=0;
        while(left<right)
        {
            cur=Math.min(height[left],height[right])*(right-left);
            if(cur>res)
                res=cur;
            if(height[left]<height[right])
            {
                left++;
            }
            else
                right--;
        }
        return res;
    }
}