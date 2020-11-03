/**
 *  Time Complexity : O((N-L)L)
 * Space Complexity : o(1)
 */

class Solution {
    public int strStr(String haystack, String needle) {
        // if needle is empty
        if (needle.equals("")) {
            return 0;
        }
        
        int m = haystack.length();
        int n = needle.length();
        // if needle is longer than haystack then needle is definitely not a part of haystack
        if (n > m) {
            return -1;
        }
        
        int ptr1 = 0; // pointer to haystack
        int ptr2 = 0; // pointer to needle
        
        // for every ptr1 there should be atleast l2 length substring after it for needle to be a part of haystack
        m = (m - n) + 1; 
		
		char c2 = needle.charAt(ptr2); // points to first char in needle
        
        // traverse through haystack
        while (ptr1 < m) {
            char c1 = haystack.charAt(ptr1); // points to a char in haystack
            
            // if first char of needle is found in haystack then check if complete neddle is a part of haystack (using substring)
            if (c1 == c2) {
                String str = haystack.substring(ptr1, ptr1 + n);
                
                if (str.equals(needle)) {
                    return ptr1; // index of the first occurrence of needle in haystack
                }
            }
            
            ptr1++;
        }
    
        return -1;
    }
}