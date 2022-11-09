//{ Driver Code Starts
#include<bits/stdc++.h> 
using namespace std;

// } Driver Code Ends
class Solution{
public: 
    long long int largestPrimeFactor(int N){
        // code here
        int n = N;
        vector<int> primes(n, 1);
        primes[0]=0;
        primes[1]=0;
        
        for(int i = 2;i*i<N;i++)
        {
            int k = 2*i;
            while(k<n)
            {
                primes[k] = 0;
                k=k+i;
            }
        }
        int i = n-1;
        while(i>=0 && primes[i] == 0 || N%i != 0) i--;
        if(i<0) return N;
        return i;
    }
};

//{ Driver Code Starts.
int main() 
{ 
    int t;
    cin>>t;
    while(t--)
    {
        int N;
        cin>>N;
        Solution ob;
        cout << ob.largestPrimeFactor(N) << endl;
    }
    return 0; 
}
// } Driver Code Ends