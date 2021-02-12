// https://leetcode.com/problems/implement-strstr/
// Time complexity : O(n*m)
// Space complexity : O(1)
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        int h = haystack.length();
        int n = needle.length();
        for (int i = 0; i < h; i++) {
            if (haystack.charAt(i) == needle.charAt(0) && (i + n) <= h) {
                int t = i;
                int j = 0;
                while (t < h && j < n && needle.charAt(j) == haystack.charAt(t)) {
                    j++;
                    t++;
                }
                if (j == n)
                    return i;
            }
        }
        return -1;
    }
}
