class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> list=new ArrayList();
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<=9;i++)
        {
            sb.append(i);
            getNumbers(2,n,k,sb,list);
            sb.setLength(0);
        }
        int ans[]=new int[list.size()];
        for(int i=0;i<list.size();i++)
        {
            ans[i]=list.get(i);
        }
        return ans;
    }
    public void getNumbers(int i, int n, int k,StringBuilder sb,List<Integer> list)
    {
        if(i>n)
        {
            list.add(Integer.parseInt(sb.toString()));
            return;
        }
        int prev=sb.charAt(i-2)-'0';
        if(k!=0&&prev+k<=9)
        {
            sb.append((char)(prev+k+'0'));
            getNumbers(i+1,n,k,sb,list);
            sb.setLength(sb.length()-1);
        }
        if(prev-k>=0)
        {
            sb.append((char)(prev-k+'0'));
            getNumbers(i+1,n,k,sb,list);
            sb.setLength(sb.length()-1);
        }
    }
}