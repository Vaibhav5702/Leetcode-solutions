class Solution {
    public int countVowelPermutation(int n) {
       // 0->a 1->e 2->i 3->o 4->u
        //a=e+i+u
        //e=a+i
        //i=e+o
        //o=i
        //u=i+o
        long[][] dp=new long[5][n+1];
        for(int i=0;i<5;i++)
        {
            dp[i][1]=1;
        }
        for(int i=2;i<=n;i++)
        {
            dp[0][i]=(dp[1][i-1]+dp[2][i-1]+dp[4][i-1])%1000000007;
            dp[1][i]=(dp[0][i-1]+dp[2][i-1])%1000000007;
            dp[2][i]=(dp[1][i-1]+dp[3][i-1])%1000000007;
            dp[3][i]=(dp[2][i-1])%1000000007;
            dp[4][i]=(dp[2][i-1]+dp[3][i-1])%1000000007;
        }
        long sum=0;
        for(int i=0;i<5;i++)
        {
            sum+=dp[i][n];
        }
        return (int)(sum%1000000007);
    }
}