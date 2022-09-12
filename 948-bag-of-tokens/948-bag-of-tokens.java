class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int low=0,high=tokens.length-1;
        int count=0,max=0;
        while(low<=high)
        {
            if(power>=tokens[low])
            {
                power-=tokens[low];
                low++;
                count++;
                max=Math.max(max,count);
            }
            else if(count!=0)
            {
                power+=tokens[high];
                high--;
                count--;
            }
            else return 0;
        }
        return max;
    }
}