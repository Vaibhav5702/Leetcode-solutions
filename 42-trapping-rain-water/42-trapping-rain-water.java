class Solution {
    public int trap(int[] height) {
        int lmax[]=new int[height.length];
        int rmax[]=new int[height.length];
        lmax[0]=height[0];
        rmax[height.length-1]=height[height.length-1];
        for(int i=1;i<height.length;i++)
        {
            lmax[i]=Math.max(height[i],lmax[i-1]);
            rmax[height.length-1-i]=
                Math.max(height[height.length-1-i],rmax[height.length-i]);
        }
        int res=0;
        for(int i=0;i<height.length;i++)
        {
            res+=Math.min(lmax[i],rmax[i])-height[i];
            
        }
        return res;
    }
}