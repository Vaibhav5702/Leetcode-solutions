class Solution {
    public int[] countBits(int n) {
        if(n==0)
            return new int[]{0};
        int bits[]=new int[n+1];
        bits[0]=0;
        bits[1]=1;
        for(int i=2;i<=n;i*=2)
        {
            int min=Math.min(n+1,i*2);
            for(int j=i;j<min;j++)
            {
                bits[j]=1+bits[j%i];
            }
        }
        return bits;
    }
}