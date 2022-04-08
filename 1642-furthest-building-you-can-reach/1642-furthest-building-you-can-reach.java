class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq=new PriorityQueue(Collections.reverseOrder());
        int i;
        for(i=1;i<heights.length;i++)
        {
            int diff=heights[i]-heights[i-1];
            if(diff<=0)
                continue;
            if(bricks>=diff)
            {
                pq.offer(diff);
                bricks-=diff;
            }
            else
            {
                if(ladders==0)
                    break;
                if(!pq.isEmpty()&&pq.peek()>diff)
                {
                    bricks+=pq.poll()-diff;
                    pq.offer(diff);
                }
                ladders--;
            }
        }
        return i-1;
    }
}