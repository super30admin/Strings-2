//Time : O(n*m)
//Space : O(1)
class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        // If the needle is empty, return 0 (as per the problem statement)
        if (m == 0) {
            return 0;
        }

        // Slide the window over the haystack
        for (int i = 0; i <= n - m; i++) {
            // Check if the substring haystack[i:i+m] matches needle
            if (haystack.substring(i, i + m).equals(needle)) {
                return i;  // First occurrence found, return index
            }
        }

        // If no occurrence found, return -1
        return -1;
    }
}
