class Solution {
    int max;
    public int maxUniqueSplit(String s) {
        max=0;
        Set<String> set=new HashSet();
        getSubstring(0,s.length(),s,set);
        return max;
    }
    public void getSubstring(int index,int n,String s,Set<String> set)
    {
        if(index==n)
        {
            max=Math.max(max,set.size());
        }
        for(int i=index+1;i<=n;i++)
        {
            String sub=s.substring(index,i);
            if(set.contains(sub))
                continue;
            set.add(sub);
            getSubstring(i,n,s,set);
            set.remove(sub);
        }
    }
}