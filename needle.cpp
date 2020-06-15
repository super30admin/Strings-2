// Sliding window
// Time Complexity : O(mn); m length of needle; n length of haystack 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : TLE
// Any problem you faced while coding this : No

// 1. Once a match for first needle char is found, set it to start and keep incrementing end till the match breaks or entire needle is parsed
// 2. On a complete match, return starts. On a mismatch, increment start and set end to start
// 3. Return -1 at the end

class Solution {
public:
    int strStr(string haystack, string needle) {
        if(needle.size()==0)
            return 0;
        if(haystack.size()==0)
            return -1;
        int start=0, end=0, nstart=0;
        while(end<haystack.size()){
            if(haystack[end]==needle[nstart]){
                start=end;
                cout<<"start: "<<start<<" end: "<<end<<endl;
                while(nstart<needle.size() && haystack[end]==needle[nstart]){
                    end++;
                    nstart++;
                }
                if(nstart == needle.size())
                    return start;
                else{
                    nstart=0;
                    start++;
                    end = start;
                }
            }
            else
                end++;
        }
        return -1;
    }
};