class Solution {
    public int countTexts(String pressedKeys) {
        int count=1;
        long total=1;
        for(int i=1;i<pressedKeys.length();i++)
        {
            if(pressedKeys.charAt(i)!=pressedKeys.charAt(i-1))
            {
                if(pressedKeys.charAt(i-1)=='7'||pressedKeys.charAt(i-1)=='9')
                    total=(total*count7or9(count))%1000000007;
                else
                    total=(total*countOthers(count)%1000000007);
                count=1;
            }
            else
                count++;
        }
        if(pressedKeys.charAt(pressedKeys.length()-1)=='7'||pressedKeys.charAt(pressedKeys.length()-1)=='9')
            total=(total*count7or9(count))%1000000007;
        else
            total=(total*countOthers(count)%1000000007);
        return (int)total;
    }
    public long count7or9(int count)
    {
        long[] ways=new long[count+1];
        if(count==1)
            return 1;
        else if(count==2)
            return 2;
        else if(count==3)
            return 4;
        else if(count==4)
            return 8;
        ways[1]=1;
        ways[2]=2;
        ways[3]=4;
        ways[4]=8;
        for(int i=5;i<=count;i++)
        {
            ways[i]=(ways[i-1]+ways[i-2]+ways[i-3]+ways[i-4])%1000000007;
        }
        return ways[count];
    }
    public long countOthers(int count)
    {
        long[] ways=new long[count+1];
        if(count==1)
            return 1;
        else if(count==2)
            return 2;
        else if(count==3)
            return 4;
        ways[1]=1;
        ways[2]=2;
        ways[3]=4;
        for(int i=4;i<=count;i++)
        {
            ways[i]=(ways[i-1]+ways[i-2]+ways[i-3])%1000000007;
        }
        return ways[count];
    }
}