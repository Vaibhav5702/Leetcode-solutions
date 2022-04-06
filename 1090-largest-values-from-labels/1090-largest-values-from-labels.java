class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit){
        int arr[][]=new int[values.length][2];
        for(int i=0;i<arr.length;i++)
        {
            arr[i][0]=values[i];
            arr[i][1]=labels[i];
        }
        Arrays.sort(arr,(a,b)->b[0]-a[0]);
        int count[]=new int[20001];
        int score=0;
        for(int a[]:arr)
        {
            if(count[a[1]]==useLimit)
                continue;
            score+=a[0];
            numWanted--;
            count[a[1]]++;
            if(numWanted==0)
                return score;
        }
        return score;
    }
}