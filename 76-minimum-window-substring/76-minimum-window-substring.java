class Solution {
    public String minWindow(String s, String t) {
        int[] freqt=new int[58];
        int[] freqs=new int[58];
        String res=""; 
        for(char ch:t.toCharArray())
        {
            freqt[ch-'A']++;
        }
        Queue<Integer> queue=new LinkedList();
        for(int i=0;i<s.length();i++)
        {
            char k=s.charAt(i);
            if(freqt[k-'A']>0)
            {
                queue.offer(i);
                freqs[k-'A']++;
                while(queue.size()>=t.length()&&compare(freqs,freqt))
                {
                    if(res==""||i-queue.peek()+1<res.length())
                    {
                        res=s.substring(queue.peek(),i+1);
                    }
                    freqs[s.charAt(queue.peek())-'A']--;
                    queue.poll();   
                }
            }
        }
        return res;
    }
    public boolean compare(int[] arr1,int[] arr2)
    {
        for(int i=0;i<58;i++)
        {
            if(arr1[i]<arr2[i])
                return false;
        }
        return true;
    }
}