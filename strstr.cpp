// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
#include <iostream>
#include <unordered_set>

using namespace std;
class Solution {
public:
    int strStr(string haystack, string needle) {
        int m = haystack.length();
        int n = needle.length();
        long long k = (long long)(pow(26, n-1));
        long long needleHash = 0;

        for (int i=0; i < n; i++) {
            int ch = needle[i];
            needleHash = needleHash*26 +(ch - 'a' +1);
        }
        long long sourceHash = 0;
        for (int i=0; i<m ; i++) {
            //out 
            if (i>=n){
                char out = haystack[i-n];
                sourceHash = sourceHash -((out - 'a' +1)*k);
            }
            // in
            char in = haystack[i];
            sourceHash = sourceHash*26 +(in - 'a' +1);
            if (sourceHash == needleHash) return i-n+1;
        }
        return -1;
    }
};