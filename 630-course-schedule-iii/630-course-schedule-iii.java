class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(a,b)->a[1]-b[1]);
        PriorityQueue<Integer> pq=new PriorityQueue(Collections.reverseOrder());
        int time=0,count=0;
        for(int i=0;i<courses.length;i++)
        {
            int[] course=courses[i];
            if(course[0]+time<=course[1])
            {
                count++;
                time+=course[0];
                pq.offer(course[0]);
            }
            else
            {
                if(!pq.isEmpty()&&pq.peek()>course[0])
                {
                    time-=pq.poll()-course[0];
                    pq.offer(course[0]);
                }
            }
        }
        return count;
    }
}