class Solution {
    public int minimumBuckets(String street) {
        char[] arr=street.toCharArray();
        int bucket=0;
        if(street.length()==1)
        {
            if(arr[0]=='.')
                return 0;
            return -1;
        }
        int n=street.length();
        if(arr[0]=='H'){
            if(arr[1]=='.')
            {
            arr[1]='b';
            bucket++;
            }
            else
                return -1;
        }
        if(arr[n-1]=='H'){
            if(arr[n-2]=='b')
                return 1;
            if(arr[n-2]=='.')
            {
            arr[n-2]='b';
            bucket++;
            }
            else
                return -1;
        }
        for(int i=1;i<n-1;i++)
        {
            if(arr[i]=='H')
            {
                if(arr[i-1]=='b'||arr[i+1]=='b')
                    continue;
                if(arr[i+1]=='.')
                {
                    arr[i+1]='b';
                    bucket++;
                }
                else if(arr[i-1]=='.')
                {
                    arr[i-1]='b';
                    bucket++;
                }
                else
                    return -1;
            }
        }
        return bucket;
    }
}