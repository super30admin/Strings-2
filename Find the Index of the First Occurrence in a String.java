class Solution {
    // TC: O(n * m) in worst case, where n = haystack.length(), m = needle.length()
    // SC: O(1)
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        for (int i = 0; i <= n - m; i++) {
            if (haystack.substring(i, i + m).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
