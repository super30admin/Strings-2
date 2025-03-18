// Time complexity:-O(m * n)
// Space complexity:-  O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * Approach: 
 * This problem is about finding the index of the first occurrence of the string `needle` in the string 'haystack'.
 * I used a sliding window approach where I iterate through each character of `haystack` and check if the substring starting from that character matches `needle`.
 * If a match is found, I return the starting index of the match, otherwise, I continue searching until the end of 'haystack' or return -1 if no match is found.
 */ 
class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();

        int i = 0;
        // Iterate through the haystack string
        while(i < m) {
            char hCh = haystack.charAt(i);
            char nCh = needle.charAt(0);
            // If the current character in haystack matches the first character of needle
            if (hCh == nCh) {
                // First character matches, now check the entire string match starting from this index in haystack
                //Initialize pointers to compare remaining characters
                int k = i;
                int j = 0;

                // Check if the entire substring in haystack matches the needle
                while (k < m && j < n) {
                    // If characters match, move both pointers forward
                    if (haystack.charAt(k) == needle.charAt(j)) {
                        k++;
                        j++;
                    } else {
                         // If there's a mismatch, break the loop
                        break;
                    }
                }
                // If we have successfully matched all characters of needle (j == n)
                if (j == n)  {
                    return i; // Return the index where needle starts in haystack
                }
                else  {
                    i++; // If there's a mismatch, move to the next character in haystack
                }
                }
            } else {
                i++; // If the first character doesn't match, move to the next character in haystack
            }
        }
        // Return -1 if no match was found       
        return -1;
    }
}