class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        int num_char0=0,num_char1=0;
        for(char ch:text.toCharArray())
        {
            if(ch==pattern.charAt(0))
                num_char0++;
            else if(ch==pattern.charAt(1))
                num_char1++;
        }
        if(pattern.charAt(0)==pattern.charAt(1))
        {
            long sum=((long)(num_char0)*(num_char0+1))/2;
            return sum;
        }
        int count=num_char1;
        long sum=0;
        for(char ch:text.toCharArray())
        {
            if(ch==pattern.charAt(0))
                sum+=count;
            else if(ch==pattern.charAt(1))
            {
                count--;
            }
        }
        if(num_char0>num_char1)
            return sum+num_char0;
        else
            return sum+num_char1;
    }
}