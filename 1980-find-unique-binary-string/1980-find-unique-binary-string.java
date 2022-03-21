class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<nums.length;i++)
        {
            char k=nums[i].charAt(i);
            if(k=='0')
                sb.append('1');
            else
                sb.append('0');
        }
        return sb.toString();
    }
}