// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
// Time Complexity : O(n*m) where n and m is the length of the haystack and needle
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Iterate through haystack and check each substring of length needle is equal to needle

class Solution {
    public:
        int strStr(string haystack, string needle) {
            for(int i=0; i<haystack.length(); i++){
                if(haystack.substr(i, needle.length()) == needle) return i;
            }
            return -1;
    
        }
    };