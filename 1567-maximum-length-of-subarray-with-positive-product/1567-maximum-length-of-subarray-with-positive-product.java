class Solution {
    public int getMaxLen(int[] nums) {
        // int count=0,nCount=0;
        // boolean pos=true;
        // int max=0;
        // for(int i=0;i<nums.length;i++)
        // {
        //     if(nums[i]==0){
        //         max=Math.max(max,count);
        //         max=Math.max(max,nCount-1);
        //         count=0;
        //         nCount=0;
        //         pos=true;
        //     }
        //     else
        //     {
        //         if(nums[i]>0)
        //         {
        //             if(pos)
        //                 count++;
        //             else
        //                 nCount++;
        //         }
        //         else
        //         {
        //             if(!pos){
        //                 count+=nCount+1;
        //             }
        //             else
        //             {
        //                 max=Math.max(max,count);
        //                 nCount=1;
        //             }
        //             pos=!pos;
        //         }
        //     }
        // }
        // max=Math.max(max,count);
        // max=Math.max(max,nCount-1);
        // return max;
        int first=-1,zero=-1;
        boolean pos=true;
        int max=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]<0)
            {
                if(first==-1)
                    first=i;
                pos=!pos;
                if(pos)
                    max=Math.max(max,i-zero);
            }
            else if(nums[i]==0)
            {
                if(pos)
                    max=Math.max(max,i-zero-1);
                else
                    max=Math.max(max,i-first-1);
                zero=i;
                first=-1;
                pos=true;
            }
            else if(pos)
            {
                max=Math.max(max,i-zero);
            }
        }
        if(pos)
            max=Math.max(max,nums.length-zero-1);
        else
            max=Math.max(max,nums.length-first-1);
        return max;
    }
}