class Solution {
    public int monotoneIncreasingDigits(int n) {
        char[] ch=Integer.toString(n).toCharArray();
        int equal=0,i;
        for(i=0;i<ch.length-1;i++)
        {
            if(ch[i]<ch[i+1])
                equal=0;
            else if(ch[i]==ch[i+1])
                equal++;
            else
                break;
            
        }
        if(i==ch.length-1)
            return n;
        for(int k=0;k<equal;k++)
        {
            ch[i-k]='9';
        }
        ch[i-equal]--;
        for(i=i+1;i<ch.length;i++)
        {
            ch[i]='9';
        }
        return Integer.parseInt(String.valueOf(ch));
    }
}