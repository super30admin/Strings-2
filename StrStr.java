// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }

        int nLen = needle.length();
        int hLen = haystack.length();
        if (nLen == 0) {
            return 0;
        }
        if (hLen == 0) {
            return -1;
        }

        int[] table = kmpLookupTable(needle);
        int i = 0;
        int j = 0;
        while (i < hLen && j < nLen) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                if (j > 0) {
                    j = table[j - 1];
                } else {
                    i++;
                }
            }
        }

        if (j == nLen) {
            return i - j;
        }
        return -1;
    }

    private int[] kmpLookupTable(String s) {
        int[] table = new int[s.length()];
        int i = 1;
        int index = 0;
        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(index)) {
                table[i] = index + 1;
                index++;
                i++;
            } else {
                if (index > 0) {
                    index = table[index - 1];
                } else {
                    table[i] = 0;
                    i++;
                }
            }
        }
        return table;
    }
}
