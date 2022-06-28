class Solution {
    public int minDeletions(String s) {
        int freq[]=new int[26];
        for(char ch:s.toCharArray())
        {
            freq[ch-'a']++;
        }
        Arrays.sort(freq);
        int av=freq[25]-1;
        int count=0;
        for(int i=24;i>=0;i--)
        {
            if(freq[i]==0)
                break;
            if(freq[i]>av)
            {
                count+=freq[i]-av;
                av=av==0?0:av-1;
            }
            else
                av=freq[i]-1;
        }
        return count;
    }
}