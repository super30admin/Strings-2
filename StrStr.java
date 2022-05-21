// O(n^2), nested for loop, traverse all chars of needle string for every element in haystack string, 
// O(1) space

class Solution {
    public int strStr(String haystack, String needle) {
        char[] charsH = haystack.toCharArray();
        char[] charsN = needle.toCharArray();
        
        if (needle.length() == 0) return 0;
        
        for (int i = 0 ; i < haystack.length(); i++){
            if (i + needle.length() > haystack.length()) break;
            for (int j = 0; j < needle.length(); j++){
                if (haystack.charAt(i+j) != needle.charAt(j)) break; // " + i", which is the starting index 
                if (j == needle.length() - 1) return i;
            }
        }
        return -1;
    }
}