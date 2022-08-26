class Solution {
    public boolean reorderedPowerOf2(int n) {
        int freq1[]=new int[10];
        for(char ch:Integer.toString(n).toCharArray())
        {
            freq1[ch-'0']++;
        }
        int t=1;
        for(int i=1;i<32;i++)
        {
            int freq2[]=new int[10];
            for(char ch:Integer.toString(t).toCharArray())
            {
                freq2[ch-'0']++;
            }
            if(Arrays.equals(freq1,freq2))
                return true;
            t*=2;
        }
        return false;
    }
}