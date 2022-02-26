class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0,count=0,max=0;
        String b="";
        while(i<s.length())
        {
            char k=s.charAt(i);
            if(b.indexOf(k)==-1)
            {
                b=b+k;
                count++;
            }
            else
            {
                if(count>max)
                    max=count;
                int j=b.indexOf(k);
                b=b.substring(j+1)+k;
                count=b.length();
            }
            i++;
        }
        return Math.max(count,max);
    }
}