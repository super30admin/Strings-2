// time complexity 0(n)
// space complexity 0(n)
// code successfully executed on leetcode
 class Solution {
    public int strStr(String haystack, String needle) {
      int l1 = haystack.length(), l2 = needle.length();
        if (l1 < l2) {
            return -1;
        } else if (l2 == 0) {
            return 0;
        }
        for (int i = 0; i <= l1-l2; ++i) {
            if (haystack.substring(i,i+l2).equals(needle)) {
                return i;
            }
        }
        return -1;
}
}