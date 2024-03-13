/*
text length = n, patern length = m

Time: O(n)
Space: O(m)

Use robin-carp hash rolling or sliding window hash to find the first match
*/

class Solution {
public:
    const int p = 31, mod = 1e9+7;
    int strStr(string s, string pat) {
        int n = s.length(), k = pat.length();
        if(n<k)  return -1;

        long long hash = 0;
        long long pow = 1;
        
        for(int i=k-1;i>=0;i--){
            hash = (hash+pat[i]*pow) % mod;
            pow = (pow*p) % mod;
        }

        pow = 1;
        long long hval = 0;
        for(int i=k-1;i>=0;i--){
            hval = (hval+s[i]*pow) % mod;
            if(i>0)  pow = (pow*p) % mod;
        }

        if(hval==hash)  return 0;
        //cout<<hash<<endl;

        int val = (-7)%4;

        //h[0...2] = p^2*s[0] + p*s[1] + s[2]
        //h[1...3] = p^2*s[1] + p*s[2] + s[3]
        //         = p*(h[0..2] - p^2*s[0]) + s[3]
        for(int i=k;i<n;i++){
            //subtract first, take care of negative and then multiply
            hval = (hval - (pow * s[i-k]) % mod) % mod; 
            hval = (hval + mod) % mod; //take care of negative
            hval = (hval * p) % mod;
            hval = (hval + s[i]) % mod; //add new element of the current window

            //cout<<s.substr(i-k+1,k)<<" "<<hval<<endl;

            if(hval==hash)  return i-k+1;
        }
        
        return -1;
    }
};
