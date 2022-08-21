class Solution {
    public int secondsToRemoveOccurrences(String s) {
        int count=0;
        while(true)
        {
            StringBuilder sb=new StringBuilder();
            boolean flag=false;
            int i=0;
            for(i=0;i<s.length()-1;i++)
            {
                if(s.charAt(i)=='0'&&s.charAt(i+1)=='1'){
                    sb.append("10");
                    flag=true;
                    i++;
                }
                else
                {
                    sb.append(s.charAt(i));
                }
            }
            if(i==s.length()-1)
                sb.append(s.charAt(i));
            s=sb.toString();
            if(!flag)
                return count;
            count++;
        }
    }
}