class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> list=new ArrayList();
        int a[]=new int[26];
        for(int i=0;i<s.length();i++)
        {
            a[s.charAt(i)-'a']=i;
        }
        int start=0,last=0;
        for(int i=0;i<s.length();i++)
        {
            last=Math.max(last,a[s.charAt(i)-'a']);
            if(i==last)
            {
                list.add(last-start+1);
                start=last+1;
            }
        }
        return list;
    }
}