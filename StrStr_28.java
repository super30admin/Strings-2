/*
Time: O(H) where H is haystack size
Space: O(1) 
*/

// ============= Using built-in indexof ========================

class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}

// ================ Without using indexOf ========================

class Solution {
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0) return 0;
        if(haystack == null || haystack.length() == 0 || haystack.length() < needle.length()) return -1;
        
        int nsize = needle.length();
        int start = 0, end = nsize;
        while(end <= haystack.length()) {
            if(haystack.substring(start, end).equals(needle))
                return start;
            start++;
            end++;
        }
        return -1;
    }
}