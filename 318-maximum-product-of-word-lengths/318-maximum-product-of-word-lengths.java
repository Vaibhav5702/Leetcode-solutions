class Solution {
    public int maxProduct(String[] words) {
        int[] binary=new int[words.length];
        int max=0;
        for(int i=0;i<words.length;i++)
        {
            int val=0;
            for(char ch:words[i].toCharArray())
            {
                val|=1<<(ch-'a');
            }
            binary[i]=val;
        }
        for(int i=0;i<words.length;i++)
        {
            for(int j=i+1;j<words.length;j++)
            {
                if((binary[i]&binary[j])==0)
                {
                    max=Math.max(max,words[i].length()*words[j].length());
                }
            }
        }
        return max;
    }
}