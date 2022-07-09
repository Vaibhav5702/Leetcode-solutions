class Solution {
    public int numSteps(String s) {
        s='0'+s;
        char[] ch=s.toCharArray();
        int len=ch.length;
        int count=0;
        while(true){
            int i;
            for(i=0;i<len-1;i++)
            {
                if(ch[i]!='0')
                    break;
            }
            if(i==len-1)
                break;
            count++;
            if(ch[len-1]=='1')
            {
                int j=len-1;
                while(ch[j]=='1')
                {
                    ch[j--]='0';
                }
                ch[j]='1';
            }
            else
            {
                len--;
            }
        }
        return count;
    }
}