class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(trainers);
        Arrays.sort(players);
        int i=players.length-1,j=trainers.length-1;
        int count=0;
        while(i>=0&&j>=0)
        {
            if(players[i]<=trainers[j])
            {
                count++;
                j--;
            }
            i--;
        }
        return count;
    }
}