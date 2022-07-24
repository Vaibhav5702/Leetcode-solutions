class Solution {
    public int numWays(String s) {
        int countOnes=0;
        for(char ch:s.toCharArray())
        {
            if(ch=='1')
                countOnes++;
        }
        if(countOnes%3!=0)
            return 0;
        if(countOnes==0)
        {
            return (int)((((long)(s.length()-1))*(s.length()-2)/2)%1000000007);
        }
        countOnes/=3;
        int left=1,right=1;
        int i=0;
        int count=0;
        for(i=0;count!=countOnes;i++)
        {
            if(s.charAt(i)=='1')
                count++;
        }
        for(;s.charAt(i)!='1';i++)
        {
            left++;
        }
        count=0;
        for(i=s.length()-1;count!=countOnes;i--)
        {
            if(s.charAt(i)=='1')
                count++;
        }
        for(;s.charAt(i)!='1';i--)
        {
            right++;
        }
        return (int)(((long)left*right)%1000000007);
    }
}