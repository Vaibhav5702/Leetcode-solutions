class Solution {
    public int maxProduct(String[] words) {
        boolean[][] freq=new boolean[words.length][26];
        int max=0;
        for(int i=0;i<words.length;i++)
        {
            for(char ch:words[i].toCharArray())
            {
                freq[i][ch-'a']=true;
            }
        }
        for(int i=0;i<words.length;i++)
        {
            for(int j=i+1;j<words.length;j++)
            {
                if(check(i,j,freq))
                {
                    max=Math.max(max,words[i].length()*words[j].length());
                }
            }
        }
        return max;
    }
    public boolean check(int i,int j, boolean[][] freq)
    {
        for(int k=0;k<26;k++)
        {
            if(freq[i][k]&&freq[j][k])
                return false;
        }
        return true;
    }
}