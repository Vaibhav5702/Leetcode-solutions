class Solution {
    public int maxDiff(int num) {
        char[] ch=Integer.toString(num).toCharArray();
        int i=0;
        while(i<ch.length&&ch[i]=='9')
            i++;
        char[] max=ch.clone();
        if(i<ch.length)
        {
            swap(max,ch[i],'9');
        }
        i=1;
        char[] min=ch.clone();
        if(ch[0]>'1')
            swap(min,ch[0],'1');
        else
        {
            while(i<ch.length&&(ch[i]=='0'||ch[i]=='1'))
                i++;
            if(i<ch.length)
            {
                swap(min,ch[i],'0');
            }
        }
        return Integer.parseInt(String.valueOf(max))-Integer.parseInt(String.valueOf(min));
    }
    public void swap(char[] arr,char ch, char value)
    {
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==ch)
                arr[i]=value;
        }
    }
}