// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
// n = haystack length
// m = needle length

// Your code here along with comments explaining your approach

// using KMP Algorithm
// TC:O(n+m)
// SC:O(m)

class Solution {
public:
    int strStr(string haystack, string needle) {
        int m = needle.size();
        int n = haystack.size();
        if(m>n) return -1;
        
        vector<int>lps(m);
        //lps
        int i = 1,p = 0;
        while(i< m)
        {
            if(needle[i] == needle[p])
            {
                p++;
                lps[i] = p;
                i++;
            }
            else if(p==0)
            {
                lps[i] = 0;
                i++;
            }
            else
            {
                p = lps[p-1];
            }
        }
        
        i = 0;
        int j = 0;
        while(i<n)
        {
            if(haystack[i]==needle[j])
            {
                i++;j++;
                if(j==m) return i-m;
            }
            else if(j==0) {
                i++;
            }
            else{
                j = lps[j-1];
            }
        }
        return -1;
    }
};

// using Rabin karp ( rolling hash)
// TC: O(n*m)
// SC: O(1)


class Solution {
public:
    using ll = long long;
    ll M = 1;
    ll  p = 31;
    ll MOD = 1e9+7;
    int strStr(string haystack, string needle) {
        int m = needle.size();
        int n = haystack.size();
        if(m>n) return -1;
        
        for(int i = 0;i<m;i++) M = (M*p)%MOD;
        
        ll hashneedle = 0,hashhay=0;
        
        hashneedle = calculatehash(needle,m);
        for(int windowstart=0;windowstart<=n-m;windowstart++)
        {
            if(windowstart == 0)
            {
                hashhay = calculatehash(haystack,m);
            }
            else
            {
                hashhay = ((p*hashhay)%MOD - ((haystack[windowstart-1])*M)%MOD + haystack[windowstart+m-1] +MOD)%MOD;

            }
            if(hashhay == hashneedle) return windowstart;
        }
        return -1;
    }
    ll calculatehash(string s,int m)
    {
        ll ans = 0;
        ll y = 1;
        for(int i = m-1;i>=0;i--)
        {
            ans+= (s[i] *y) %MOD;
            y = (y*p)%MOD;
        }
        return ans%MOD;
    }
};

//sliding window
// TC: O(nm)
// SC: O(1)

class Solution {
public:
    int strStr(string haystack, string needle) {
        int m = needle.size();
        int n = haystack.size();
        int ans = -1;
        for(int windowstart = 0;windowstart<=n-m;windowstart++)
        {
            for(int i = 0;i<m;i++)
            {
                if(haystack[windowstart+i]!=needle[i])
                {
                    break;
                }
                if(i==m-1) return windowstart;
            }
        }
        return -1;
    }
};

// using stl 

// TC: O(m*n)
// SC:O(1)
class Solution {
public:
    int strStr(string haystack, string needle) {
        return haystack.find(needle);
    }
};