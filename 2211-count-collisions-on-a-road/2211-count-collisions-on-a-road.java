class Solution {
    public int countCollisions(String directions) {
        int r=0,s=0,count=0;
        for(char ch:directions.toCharArray())
        {
            if(ch=='R'){
                r++;
                s=0;
            }
            else if(ch=='L')
            {
                if(r>0)
                {
                    count+=r;
                    r=0;
                    count++;
                    s=1;
                }
                else if(s==1)
                    count++;
            }
            else
            {
                count+=r;
                r=0;
                s=1;
            }
        }
        return count;
    }
}