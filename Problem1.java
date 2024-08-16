//Time = O(m*n), m and n are length of Hay and needle
//Space = O(1)

class Solution {
    public int strStr(String haystack, String needle) {
        // Get the length of the haystack and needle strings
        int hLen = haystack.length();
        int nLen = needle.length();
        
        // If the needle string is empty, it occurs at index 0 of the haystack
        if (nLen == 0) {
            return 0;
        }
        
        // If the length of the haystack is less than the length of the needle,
        // the needle cannot occur in the haystack
        if (hLen < nLen) {
            return -1;
        }
        
        // Check each possible starting position of the needle in the haystack
        for (int i = 0; i <= hLen - nLen; i++) {
            // Assume that there is a match between the current starting position
            // of the needle in the haystack and the needle itself
            boolean match = true;
            
            // Compare each character of the needle to the corresponding character
            // in the haystack starting from the current position
            for (int j = 0; j < nLen; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    // If any character doesn't match, the assumption of a match is incorrect
                    match = false;
                    break;
                }
            }
            
            // If all characters match, return the current starting position of the needle
            if (match) {
                return i;
            }
        }
        
        // If the needle does not occur in the haystack, return -1
        return -1;
    }
}
