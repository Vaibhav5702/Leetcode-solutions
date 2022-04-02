class Solution {
    public boolean validPalindrome(String s) {
        int low=0,high=s.length()-1;
        while(low<high)
        {
            if(s.charAt(low)==s.charAt(high))
            {
                low++;
                high--;
                continue;
            }
            int i=low+1,j=high;
            while(i<j&&s.charAt(i)==s.charAt(j))
            {
                i++;
                j--;
            }
            int m=low,n=high-1;
            while(m<n&&s.charAt(m)==s.charAt(n))
            {
                m++;
                n--;
            }
            return (i>=j)||(m>=n);
        }
        return true;
    }
}