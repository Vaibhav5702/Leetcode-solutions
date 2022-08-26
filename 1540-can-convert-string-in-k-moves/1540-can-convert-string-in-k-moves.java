class Solution {
    public boolean canConvertString(String s, String t, int k) {
        if(s.length()!=t.length())
            return false;
        int freq[]=new int[26];
        for(int i=0;i<s.length();i++)
        {
            char k1=s.charAt(i);
            char k2=t.charAt(i);
            int diff=0;
            if(k2==k1)
                continue;
            if(k2>k1)
                diff=k2-k1;
            else
                diff=k2-k1+26;
            if(freq[diff]*26+diff<=k)
                freq[diff]++;
            else
                return false;
        }
        return true;
    }
}