// Time Complexity : O(M+N) where M is the length of haystack and N is the length of needle
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
public:
    vector<int> getLps(string needle){
        int i = 1;
        int j = 0;
        vector<int> lps(needle.size(), 0);
        while(i < needle.size()){
            if(needle[i] == needle[j]){
                j++;
                lps[i] = j;
                i++;
            }
            else if(needle[i] != needle[j] && j>0)
                j = lps[j-1];
            else{
                lps[i] = 0;
                i++;
            }
        }
        return lps;
    }
    
    int strStr(string haystack, string needle) {
        if(needle.empty() || needle.size() == 0)
            return 0;
        int m = haystack.size();
        int n = needle.size();
        vector<int> lps = getLps(needle);
        int i=0, j=0;
        while(i<m){
            if(haystack[i] == needle[j]){
                i++;
                j++;
                if(j == n)
                    return abs(i-n);
            }
            else if(haystack[i] != needle[j] && j>0)
                j = lps[j-1];
            else
                i++;
        }
        return -1;
    }
};

// Time Complexity : O(M*N) where M is the length of haystack and N is the length of needle
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
public:
    int strStr(string haystack, string needle) {
        if(needle.empty() || needle.size() == 0)
            return 0;
        int m = haystack.size();
        int n = needle.size();
        for(int i=0; i<m-n+1; i++){
            if(haystack[i] == needle[0]){
                int k = i;
                int j=0;
                while(j < n && k < m){
                    if(haystack[k] == needle[j]){
                        j++;
                        k++;
                    }
                    else
                        break;
                }
                if(j == n)
                    return abs(k-n);
            }
        }
        return -1;
    }
};


// Time Complexity : O(M*N) where M is the length of haystack and N is the length of needle
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
public:
    int strStr(string haystack, string needle) {
        if(needle.empty() || needle.size() == 0)
            return 0;
        int m = haystack.size();
        int n = needle.size();
        for(int i=0; i<m; i++){
            if(haystack[i] == needle[0]){
                int k = i;
                int j=0;
                while(j < n && k < m){
                    if(haystack[k] == needle[j]){
                        j++;
                        k++;
                    }
                    else
                        break;
                }
                if(j == n)
                    return abs(k-n);
            }
        }
        return -1;
    }
};
