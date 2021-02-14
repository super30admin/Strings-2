// Time Complexity :O(h*n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this:getting started

// Your code here along with comments explaining your approach

public class ImplementStrStr {
    class Solution {
        public int strStr(String haystack, String needle) {
            if(needle.isEmpty()) return 0;

            //if haystack is less than needle, return -1 as needle can't be in haystack
            int h = haystack.length();
            int n = needle.length();
            if(h < n) return -1;

            //iterate from left to right and check each positin up until h-n,
            // h-n because there will not be enough room after h-n to find strings
            for (int i = 0; i <= h-n; i++) {
                int j;
                for( j = 0; j < n; ++j) {
                    if(haystack.charAt(i+j) != needle.charAt(j)) break;
                }
                if(j==n) return i; //needle found
            }
            return -1;//needle not found
        }
    }
}
