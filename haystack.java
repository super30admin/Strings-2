
// Time Complexity : O(n*m)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.length() == 0 || needle.length() == 0) {
            return -1;
        }
        int haystackLength = haystack.length();
        int needleLength = needle.length();
        for (int i = 0; i < haystackLength - needleLength + 1; i++) { // check till length of haystack - needle of length, as we are comparing substrings
            if (haystack.charAt(i) == needle.charAt(0)) { // starting letter of needle matches
                if(haystack.substring(i, i + needleLength).equals(needle) ){ // compare the lmited substring to the needle substring
                    return i; // return index
                }
            }
        }
 
        return -1; // not found
    }
}