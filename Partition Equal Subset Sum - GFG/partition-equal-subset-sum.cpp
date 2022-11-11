//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++

class Solution{
public:
    int equalPartition(int N, int arr[])
    {
        // code here
        int sum = 0;
        for(int i = 0;i<N;i++) sum += arr[i];
        vector<vector<int>> dp(N, vector<int>(sum, -1));
        return solve(N-1, arr, dp, 0, sum);
    }
    bool solve(int N, int *arr, vector<vector<int>> &dp, int currSum, int sum)
    {
        if(N<0) return 0;
        int remSum = sum - currSum;
        
        if(remSum == currSum) return 1;
        if(dp[N][currSum] != -1) return dp[N][currSum];
        return dp[N][currSum]=solve(N-1, arr, dp, currSum + arr[N], sum) || solve(N-1, arr, dp, currSum, sum);
        
        
    }
};

//{ Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        int N;
        cin>>N;
        int arr[N];
        for(int i = 0;i < N;i++)
            cin>>arr[i];
        
        Solution ob;
        if(ob.equalPartition(N, arr))
            cout<<"YES\n";
        else
            cout<<"NO\n";
    }
    return 0;
}
// } Driver Code Ends