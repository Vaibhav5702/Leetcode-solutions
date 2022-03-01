class Solution {
    public String longestPalindrome(String s) {
        int start=0,end=0;
        for(int i=0;i<s.length();i++)
        {
            int odd=get(s,i,i);
            int even=get(s,i,i+1);
            int len=Math.max(odd,even);
            if(len>end-start)
            {
                start=i-(len-1)/2;
                end=i+len/2;
            }
        }
        return s.substring(start,end+1);
    }
    public int get(String s,int low,int high)
    {
        while(low>=0&&high<s.length()&&s.charAt(low)==s.charAt(high))
        {
            low--;
            high++;
        }
        return high-low-1;
    }
}