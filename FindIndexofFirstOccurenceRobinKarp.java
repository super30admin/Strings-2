// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes, https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
// Any problem you faced while coding this : No

class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if(m<n) return -1;
           long k = 26;
           long kl = (long)Math.pow(k,n);
           long needleHash = 0;
           for(int i=0;i<n;i++){
            char c = needle.charAt(i);
            needleHash = needleHash*k+(c-'a');
           }
           // make a windown of length n in haystack
           long haystackhash = 0;
           for(int i =0;i<n;i++){
            char c = haystack.charAt(i);
            haystackhash = haystackhash*k+(c-'a');
           }
           if(needleHash==haystackhash) return 0;

           for(int start =1;start<=m-n;start++){
            // in character
            char in = haystack.charAt(start+n-1);
            haystackhash = haystackhash*k+(in-'a');
            
            //out character
            char out = haystack.charAt(start-1);
            haystackhash = haystackhash-((out-'a')*kl);

             if(needleHash==haystackhash) return start;
           }
           return -1;
        }

}
