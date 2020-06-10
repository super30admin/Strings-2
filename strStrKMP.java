// Time Complexity : O(m+n)  where n is the length of the string 1 and m is the length of string 2
// Space Complexity : O(1) hashmap/array with 26 characters at max
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Complicated solution
/* Your code here along with comments explaining your approach: Create a table array to keep a track of the prefix count, if seen before. We keep
the longest prefix suffix table length. Parse the haystack string and check if there is a match. If there is a match move on, and any mismatch occurs
move one of the pointers to the position next to the current prefix if seen before. As the pointer reaches end of the needle string we are done and return
the starting index of the string.
*/
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle == "" || needle.length() == 0){return 0;}
        int[] table = new int[needle.length()];                                             // Longest common prefix suffix table
        int start =0;                                                                                             
        int m = haystack.length();
        int i = 1;
        table[start] = 0;                                                               // First entry of the table is 0 always
        while(i < needle.length()){
            if(needle.charAt(start) == needle.charAt(i)){                           // If the character is seen again
                start++;
                table[i] = start;                                                               // Prefix has been seen before, increment counter
                i++;
            } else 
            if(start > 0 && needle.charAt(start) != needle.charAt(i)){                                  // Revert back start
                start = table[start-1];
            } else 
            if(start == 0 && needle.charAt(start) != needle.charAt(i)){                    // Starting character is not same as current char,  put 0
                table[i] =  0;
                i++;
            }
        }
        i=0;
        int j = 0;
        while(i < m){                                                                       // Till the end of haystack string
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;                                                                                    // If matching characters, move on
                j++;
            }
            if(j == needle.length()){                                                                   // Return the starting index if end of needle string is reached
                return i - needle.length();}
            else
            if(i < m && j > 0 && haystack.charAt(i) != needle.charAt(j)){
                j = table[j-1];                                                                 // If not a match, revert the j pointer after the position next to the current prefix if seen before
            } else
            if(i < m && j == 0 && haystack.charAt(i) != needle.charAt(j)){                          // If starting character mismatch, move on
                i++;
            }
        }
        return -1;                                                                          // Not found
}
}