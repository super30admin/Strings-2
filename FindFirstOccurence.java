// Time Complexity : 
// Space Complexity : 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length())
            return -1;
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            j = i + needle.length();
            if (j <= haystack.length() && haystack.substring(i, j).equals(needle))
                return i;
        }

        return -1;
    }
}