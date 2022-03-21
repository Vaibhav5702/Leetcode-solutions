class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> list=new ArrayList<String>();
        getIp(s,4,list,new StringBuilder());
        return list;
    }
    public void getIp(String s,int rem,List<String> list,StringBuilder sb)
    {
        if(rem==0||s.length()==0)
        {
            if(rem==0&&s.length()==0)
            {
                sb.setLength(sb.length()-1);
                list.add(sb.toString());
                sb.append(".");
            }
            return;
        }
        if(rem*3<s.length())
        {
            return;
        }
        for(int i=1;i<=Math.min(3,s.length());i++)
        {
            String a=s.substring(0,i);
            if(Integer.parseInt(a)<=255&&(a.length()==1||a.charAt(0)!='0'))
            {
                getIp(s.substring(i),rem-1,list,sb.append(a+"."));
                sb.setLength(sb.length()-(a+".").length());
            }
        }
    }
}