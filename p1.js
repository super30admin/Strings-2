// ## Problem1 
// Implement strStr() (https://leetcode.com/problems/implement-strstr/)

// Time Complexity : O((N - M)M)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
const strStr = function(haystack, needle) {
    if(!needle || needle.length === 0) return 0;
    if(haystack.length < needle.length) return -1; 
    for(let i = 0; i < haystack.length - needle.length + 1; i++) {
        if(haystack[i] === needle[0]) {
            for(let j = 0; j < needle.length; j++) {
                if(needle[j] !== haystack[i+j]) break;
                if(j === needle.length - 1) return i;
            }
        }
    }
    return -1;
};