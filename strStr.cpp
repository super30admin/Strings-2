// Brute Force
// Time COmplexity -> O(m*n)
// Space Complexity -> O(1)
// Problems Faced - No!
// It runs on Leetcode!
class Solution {
public:
    int strStr(string haystack, string needle) {
        int hL = haystack.length();
        int nL = needle.length();
        
        int h = 0;
        int n = 0;
        
        while(h <= hL-nL){
            if(haystack[h] == needle[n]){
                int k = h;
                while(haystack[k] == needle[n]){
                    k++;
                    n++;
                    if(n == nL)
                        return h;
                }
                n = 0;
            }
            h++;
        }
        return -1;
    }
};

// KMP Algorithm
// Time COmplexity -> O(m+n)
// Space Complexity -> O(1)
// Problems Faced - No!
// It runs on Leetcode!
class Solution {
    private:
    vector<int> lpsF(string s){
        int l = s.length();
        vector<int> lps(l);
        int i = 1;
        int j = 0;
        lps[0] = 0;
        
        while(i < l){
            if(s[i] == s[j]){
                j++;
                lps[i] = j;
                i++;
            }
            else if(s[i] != s[j] && j > 0)
                j = lps[j-1];
            else if(s[i] != s[j] && j == 0){
                lps[i] = 0;
                i++;
            }
        }
        return lps;
    }
    
public:
    int strStr(string haystack, string needle) {
        int m = haystack.length();
        int n = needle.length();
        if(m < n)
            return -1;
        
        int i = 0; // haystack ptr
        int j = 0; // needle ptr
        
        vector<int> lps = lpsF(needle);
        
        while(i < m){
            if(haystack[i] == needle[j]){
                i++;
                j++;
                if(j == n)
                    return i-n;
            }
            else if(haystack[i] != needle[j] && j > 0){
                j = lps[j-1];
            }
            else if(haystack[i] != needle[j] && j == 0)
                i++;
        }
        return -1;
    }
};