class Solution {
    public boolean winnerOfGame(String colors) {
        int countA=0,countB=0;
        for(int i=1;i<colors.length()-1;i++)
        {
            char k=colors.charAt(i);
            if(k==colors.charAt(i-1)&&k==colors.charAt(i+1))
            {
                if(k=='A')
                    countA++;
                else
                    countB++;
            }
        }
        return countA>countB;
    }
}