// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/

// Time Complexity: O((n-m+1)*m)
// Space Complexity: O(1)

class Solution {
    public int strStr(String haystack, String needle) {

        if(needle.length() > haystack.length()) return -1;

        long hash = 0l;

        for(int i = 0; i < needle.length(); i++) {
            char in = needle.charAt(i);
            hash = hash*26 + (in - 'a' + 1);
        }

        long kl = (long)Math.pow(26, needle.length() - 1);
        long currHash = 0l;

        for(int i = 0; i < haystack.length(); i++) {

            //outgoing
            if(i >= needle.length()) {
                char out = haystack.charAt(i - needle.length());
                currHash = currHash - (out - 'a' + 1)*kl;
            }

            //incoming
            char in = haystack.charAt(i);
            currHash = currHash*26 + (in - 'a' + 1);

            if(currHash == hash) {
                return i - needle.length() + 1;
            }
        }
        return -1;
    }
}