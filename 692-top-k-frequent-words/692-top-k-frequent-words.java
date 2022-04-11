class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Arrays.sort(words);
        PriorityQueue<Pair<String,Integer>> pq=new PriorityQueue(new Comparator<Pair<String,Integer>>(){
            @Override
            public int compare(Pair<String,Integer> a, Pair<String,Integer> b)
            {
                if(b.getValue()==a.getValue())
                    return a.getKey().compareTo(b.getKey());
                return b.getValue()-a.getValue();
            }
        });
        int count=1;
        for(int i=0;i<words.length-1;i++)
        {
            if(words[i].equals(words[i+1]))
                count++;
            else
            {
                pq.offer(new Pair(words[i],count));
                count=1;
            }
        }
        pq.offer(new Pair(words[words.length-1],count));
        List<String> list=new ArrayList();
        for(int i=0;i<k;i++)
        {
            list.add(pq.poll().getKey());
        }
        return list;
    }
}