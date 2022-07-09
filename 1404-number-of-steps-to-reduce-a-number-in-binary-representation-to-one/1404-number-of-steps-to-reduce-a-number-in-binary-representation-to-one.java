class Solution {
    public int numSteps(String s) {
        s='0'+s;
        char[] ch=s.toCharArray();
        int count=0;
        while(true){
            int i;
            for(i=0;i<ch.length-1;i++)
            {
                if(ch[i]!='0')
                    break;
            }
            if(i==ch.length-1)
                break;
            count++;
            if(ch[ch.length-1]=='1')
            {
                int j=ch.length-1;
                while(ch[j]=='1')
                {
                    ch[j--]='0';
                }
                ch[j]='1';
            }
            else
            {
                for(i=ch.length-1;i>=1;i--)
                {
                    ch[i]=ch[i-1];
                }
                ch[0]='0';
            }
        }
        return count;
    }
}