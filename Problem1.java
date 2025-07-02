//Time Complexity : O(n*m) where n is the length of the haystack string and m is the length of the needle string
// Space Complexity : O(n) where n is the length of the haystack string
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Three line explanation of solution in plain english:
// 1. We iterate through the haystack string and check if the first character of the needle matches the current character in haystack.
// 2. If it matches, we compare the rest of the characters in the needle with
//    the corresponding characters in the haystack.
// 3. If all characters match, we return the starting index; otherwise, we continue

class Solution {
    public int strStr(String haystack, String needle) {
        int i=0;
        int n=needle.length();
        int m=haystack.length();
        //optimize the search by check by iterating only till m-n
        while (i<=m-n){
            // If the first character of needle matches the current character in haystack
            // then we check the rest of the characters in needle
            if(haystack.charAt(i)==needle.charAt(0)){
                int k=i;
                int j=0;
                // Compare the characters of needle with the characters in haystack
                // If all characters match, return the starting index i
                while(haystack.charAt(k)==needle.charAt(j))
                {
                    k++;
                    j++;
                    // If we have matched all characters in needle, return the starting index i
                    if (j==n){
                        return i;
                    }
                }
            }
            // If the characters do not match, move to the next character in haystack
            i++;
        }
        // If needle is not found in haystack, return -1
        return -1;
    }
}