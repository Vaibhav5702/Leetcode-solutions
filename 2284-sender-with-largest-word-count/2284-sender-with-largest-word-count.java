class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        Map<String,Integer> map=new HashMap();
        int max=0;
        for(int i=0;i<messages.length;i++)
        {
            int space=0;
            for(char ch:messages[i].toCharArray())
            {
                if(ch==' ')
                    space++;
            }
            int words=map.getOrDefault(senders[i],0)+space+1;
            map.put(senders[i],words);
        }
        String res="";
        for(Map.Entry e:map.entrySet())
        {
            String key=e.getKey().toString();
            int val=(int)e.getValue();
            if(val>max)
            {
                max=val;
                res=key;
            }
            else if(val==max&&key.compareTo(res)>0)
            {
                res=key;
            }
        }
        return res;
    }
}