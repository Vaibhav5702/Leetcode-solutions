class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length()!=word2.length())
            return false;
        int freq1[]=new int[26];
        int freq2[]=new int[26];
        for(int i=0;i<word1.length();i++)
        {
            freq1[word1.charAt(i)-'a']++;
            freq2[word2.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++)
        {
            if(freq1[i]==0&&freq2[i]==0)
                continue;
            if((freq1[i]!=0&&freq2[i]==0)||(freq2[i]!=0&&freq1[i]==0))
                return false;
            int j=0;
            for(j=0;j<26;j++)
            {
                if(freq1[i]==freq2[j])
                {
                    freq2[j]=-1;
                    break;
                }
            }
            if(j==26)
                return false;
        }
        for(int i=0;i<26;i++)
        {
            if(freq2[i]!=0&&freq2[i]!=-1)
                return false;
        }
        return true;
    }
}