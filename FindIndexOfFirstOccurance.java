// Time complexity - O(n^2)
// Space complexity - O(1)
// Solved on leetcode - yes
// Did you face any issues - NO
// Solving using brute force algo
class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        
        for (int i = 0; i <= n - m; i++) {
            if (haystack.substring(i, i + m).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
