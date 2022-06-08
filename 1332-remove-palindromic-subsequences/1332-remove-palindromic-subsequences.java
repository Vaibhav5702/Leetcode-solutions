class Solution {
    public int removePalindromeSub(String s) {
        if(isPalindrome(s))
            return 1;
        else
            return 2;
    }
    public boolean isPalindrome(String s)
    {
        int l=0,r=s.length()-1;
        while(l<r)
        {
            if(s.charAt(l)!=s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}