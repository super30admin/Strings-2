//O(m+n)
class Solution {
public:
    int strStr(string haystack, string needle) {
        int m= haystack.length();
        int n = needle.length();
        if(n>m)return -1;
        const int base = 26;
        const long long mod = 100007;
        long long hash1 = 0;
        long long hash2 = 0;
        long long sl = 1;
        for(int i=0;i<n;i++){
            char c = needle[i];
            hash1 = ((hash1*base) + (c-'a'+1))%mod;
            hash2 = ((hash2*base) + (haystack[i]-'a'+1))%mod;
            if (i < n - 1) {
                sl = (sl * base) % mod;
            }
        }
        
        for(int i=0;i<=m-n;i++){
            if (hash1 == hash2) {
                    return i;
            }
            if (i < m - n) {
                // Remove the leftmost char
                hash2 = (hash2 - (haystack[i] - 'a' + 1) * sl % mod + mod) % mod;
                // Add the next char
                hash2 = (hash2 * base + (haystack[i + n] - 'a' + 1)) % mod;
            }
        }
        return -1;
    }
};

2nd approach naive
Time - O(m*n)
Space - O()
class Solution {
public:
    int strStr(string haystack, string needle) {
        int m = haystack.length();
        int n = needle.length();
        int i=0;
        while(i<=m-n){
            if(haystack[i]==needle[0]){
                int k = i;
                int j = 0;
                while(haystack[k]==needle[j]){
                    k++;
                    j++;
                    if(j==n){
                        return i;
                    }
                }
            }
            i++;
        }
        return -1;
    }
};
