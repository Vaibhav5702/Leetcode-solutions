class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0)
            return false;
        Map<Integer,Queue<Integer>> map=new HashMap();
        Arrays.sort(hand);
        for(int i=0;i<hand.length;i++)
        {
            if(!map.containsKey(hand[i]))
            {
                Queue<Integer> list=new LinkedList();
                list.offer(i);
                map.put(hand[i],list);
            }
            else
            {
                map.get(hand[i]).offer(i);
            }
        }
        boolean visited[]=new boolean[hand.length];
        for(int i=0;i<hand.length;i++)
        {
            if(visited[i])
                continue;
            int count=0;
            int val=hand[i];
            while(map.containsKey(val)&&count<groupSize)
            {
                count++;
                int index=map.get(val).poll();
                if(map.get(val).isEmpty())
                    map.remove(val);
                val++;
                visited[index]=true;
            }
            if(count!=groupSize)
                return false;
        }
        return true;
    }
}