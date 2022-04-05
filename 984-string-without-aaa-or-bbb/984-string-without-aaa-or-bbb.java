class Solution {
    public String strWithout3a3b(int a, int b) {
        char ch1,ch2;
        int pre,sec;
        if(a>b)
        {
            ch1='a';
            ch2='b';
            pre=a;
            sec=b;
        }
        else
        {
            ch2='a';
            ch1='b';
            pre=b;
            sec=a;
        }
        StringBuilder sb=new StringBuilder();
        while(pre>sec&&sec>0)
        {
            sb.append(ch1);
            sb.append(ch1);
            sb.append(ch2);
            pre-=2;
            sec-=1;
        }
        while(pre!=0)
        {
            sb.append(ch1);
            if(sec!=0)
                sb.append(ch2);
            pre--;
        }
        return sb.toString();
    }
}