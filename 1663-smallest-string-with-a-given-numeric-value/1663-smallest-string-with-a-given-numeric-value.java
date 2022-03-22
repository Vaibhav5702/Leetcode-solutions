class Solution {
    public String getSmallestString(int n, int k) {
        char[] ch=new char[n];
        for(int i=0;i<n;i++)
        {
            ch[i]='a';
        }
        k=k-n;
        for(int i=n-1;i>=0;i--)
        {
            if(k<=25)
            {
                ch[i]=(char)(ch[i]+k);
                return String.valueOf(ch);
            }
            k-=25;
            ch[i]='z';
        }
        return String.valueOf(ch);
    }
}