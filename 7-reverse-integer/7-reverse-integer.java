class Solution {
    public int reverse(int x) {
        int r;
        String b="";
        if(x<0)
            b="-";
        try
        {
        do
        {
            r=Math.abs(x%10);
            b=b+r;
            x/=10;
            System.out.println(r);
        }while(x!=0);
        return Integer.parseInt(b);
        }
        catch(Exception e)
        {
            return 0;
        }
    }
}