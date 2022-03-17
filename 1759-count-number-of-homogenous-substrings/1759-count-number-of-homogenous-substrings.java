class Solution {
    public int countHomogenous(String s) {
        int count=1,sum=0;
        for(int i=0;i<s.length()-1;i++)
        {
            sum=(sum+count)%1000000007;
            if(s.charAt(i)==s.charAt(i+1))
                count++;
            else
            {
                count=1;
            }
        }
        sum=(sum+count)%1000000007;
        return (int)sum%1000000007;
    }
}