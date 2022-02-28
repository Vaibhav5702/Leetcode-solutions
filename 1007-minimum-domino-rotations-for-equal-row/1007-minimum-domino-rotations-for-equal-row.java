class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int top=tops[0],bottom=bottoms[0],t1=0,t2=0,b1=0,b2=0,i,j;
        for(i=0;i<tops.length;i++)
        {
            if(top!=tops[i]&&top!=bottoms[i])
                break;
            if(top==tops[i])
            {
                t1++;
            }
            if(top==bottoms[i])
            {
                b1++;
            }
            
        }
        for(j=0;j<tops.length;j++)
        {
            if(bottom!=bottoms[j]&&bottom!=tops[j])
                break;
            if(bottom==bottoms[j])
            {
                b2++;
            }
            if(bottom==tops[j])
            {
                t2++;
            }
            
        }
        if(i!=tops.length&&j!=bottoms.length)
            return -1;
        else
        {
            top=Math.min(t1,Math.min(tops.length-t1,Math.min(b1,tops.length-b1)));
            bottom=Math.min(t2,Math.min(tops.length-t2,Math.min(b2,tops.length-b2)));
            if(j!=tops.length)
                return top;
            else if(i!=tops.length)
                return bottom;
            else
                return Math.min(top,bottom);
        }
    }
}