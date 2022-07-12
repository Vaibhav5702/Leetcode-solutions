class Solution {
    public boolean makesquare(int[] matchsticks) {
        long sum=0;
        for(int matchstick:matchsticks)
        {
            sum+=matchstick;
        }
        
        if(sum%4!=0)
            return false;
        long side=(sum/4);
        Arrays.sort(matchsticks);
        return check(matchsticks.length-1,0,0,0,0,side,matchsticks);
    }
    public boolean check(int index,long sum1,long sum2,long sum3,long sum4,long side,int[] match)
    {
        if(sum1==side&&sum2==side&&sum3==side&&sum4==side)
            return true;
        if(index==-1||sum1>side||sum2>side||sum3>side||sum4>side)
            return false;
        if(sum1!=side&&check(index-1,sum1+match[index],sum2,sum3,sum4,side,match))
            return true;
        if(sum2!=side&&check(index-1,sum1,sum2+match[index],sum3,sum4,side,match))
            return true;
        if(sum3!=side&&check(index-1,sum1,sum2,sum3+match[index],sum4,side,match))
            return true;
        if(sum4!=side&&check(index-1,sum1,sum2,sum3,sum4+match[index],side,match))
            return true;
        return false;
    }
}