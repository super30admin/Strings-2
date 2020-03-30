// Time Complexity : O(m*n) n--> no. characters in haystack, m - > no. of characters in needle
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach1: Each character of haystack is matched with needle to identify if the needle can be found in stack or not.
// If there is a mismatch, the needle's search position is reset and new search begins by shifting the start index in haystack.
/*
class Solution {
    public int strStr(String haystack, String needle) {
        // edge cases
        if(haystack == null || needle == null || needle.length() == 0) return 0;
        if(haystack.equals(needle)) return 0;
        int len1 = haystack.length();
        int len2 = needle.length();
        if(len1 < len2) return -1;
        
        int i = 0, j = 0;
        int startIndex = 0;
        while(i < len1 && (j < len2 || j < len1-len2)) { // checking boundaries
            if(haystack.charAt(i) == needle.charAt(j)) {
                if(j == 0) startIndex = i;
                i++;
                j++;
                if(j == len2) return startIndex; // when entire needle is found
            }
            else {
                j = 0; // restart needle search
                i = startIndex+1; // increment the startIndex found in previous search
                startIndex++; // keep incrementing start index until a match is found
            }
        }
        
        return -1;
    }
}
*/

// Time Complexity : O(m + n) n--> no. characters in haystack, m - > no. of characters in needle
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach2: KMP
// Intuition: If there are repeating elements in the needle, we can maintain a prefix-suffix data structure which will skip the repeated element comparison.
// Also, in the naive way of doing we were doing the comparisonby shifting position in haystack one by one. 
//Using KMP, we will always move in the forward direction and if certain comparisons do not yield result, we are not going back to compare the already seen characters.

class Solution {
    public int strStr(String haystack, String needle) {
        // edge cases
        if(haystack == null || needle == null || needle.length() == 0) return 0;
        if(haystack.equals(needle)) return 0;
        int len1 = haystack.length();
        int len2 = needle.length();
        if(len1 < len2) return -1;
        
        int[] pi = formPi(needle);
        int i = 0, j = 0;
        int startIndex = 0;
        while(i < len1 && j < len2) {
            if(haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if(j == len2) return i-j;
            }
            else {
                if(j == 0) i++;
                else {
                    j = pi[j-1]; // moving j back to a position based on pi array
                }
            }
        }
        
        return -1;
    }
    
    private int[] formPi(String pattern) {
        int i = 1, j = 0;
        int[] pi = new int[pattern.length()]; // creating a pi array for matching prefix-suffix 
        while(i < pattern.length()) {
            if(pattern.charAt(i) == pattern.charAt(j)) {
                j++;
                pi[i] = j;
                i++;
            }
            else {
                if(j != 0) {
                    j = pi[j-1];
                }
                else {
                    i++;
                }
            }
        }
        return pi;
    }
}



