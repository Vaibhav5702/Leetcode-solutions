class TopVotedCandidate {

    class Pair{
        int time;
        int person;
        Pair(int time,int person)
        {
            this.time=time;
            this.person=person;
        }
    }
    Pair[] lead;
    public TopVotedCandidate(int[] persons, int[] times) {
        int[] freq=new int[persons.length];
        lead=new  Pair[persons.length];
        int max=0,maxPerson=-1;
        for(int i=0;i<persons.length;i++)
        {
            freq[persons[i]]++;
            if(freq[persons[i]]>=max)
            {
                max=freq[persons[i]];
                maxPerson=persons[i];
            }
            lead[i]=new Pair(times[i],maxPerson);
        }
    }
    
    public int q(int t) {
        int low=0,high=lead.length-1;
        int index=-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(lead[mid].time>t)
                high=mid-1;
            else{
                index=mid;
                low=mid+1;
            }
        }
        return lead[index].person;
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */