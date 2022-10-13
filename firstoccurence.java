/*
Time Complexity: O(m*n)
Space Complexity: O(1)
*/
class Solution {
    public int strStr(String haystack, String needle) {
       for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.charAt(i) != needle.charAt(0)) {
                continue;
            }
            int j = 1;
            int match = 1;
            while (j < needle.length()) {
                if (haystack.charAt(i + j) == needle.charAt(j)) {
                    match++;
                } else {
                    break;
                }
                j++;
            }
            if (match == needle.length()) {
                return i;
            }
        }
        return -1; 
    }
}