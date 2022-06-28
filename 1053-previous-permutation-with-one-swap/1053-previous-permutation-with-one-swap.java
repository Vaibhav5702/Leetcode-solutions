class Solution {
    public int[] prevPermOpt1(int[] arr) {
        int i;
        for(i=arr.length-2;i>=0;i--)
        {
            if(arr[i]>arr[i+1])
                break;
        }
        if(i==-1)
            return arr;
        int j;
        for(j=arr.length-1;j>i;j--)
        {
            if(arr[j]<arr[i]&&arr[j]!=arr[j-1])
                break;
        }
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        return arr;
    }
}