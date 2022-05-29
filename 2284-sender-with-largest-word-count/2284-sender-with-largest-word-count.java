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
            max=Math.max(max,words);
        }
        List<String> list=new ArrayList();
        for(Map.Entry e:map.entrySet())
        {
            if((int)e.getValue()==max)
                list.add(e.getKey().toString());
        }
        Collections.sort(list,Collections.reverseOrder());
        return list.get(0);
    }
}