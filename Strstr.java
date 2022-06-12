// Time Complexity: O(m+n)
// Space Complexity: O(m+n)
// Did this code successfully run on Leetcode: yes
// Any problem you faced while coding this: yes
// Your code here along with comments explaining your approach: kmp

public class Strstr {
    public int strStr(String haystack, String needle) {
        char[] text = haystack.toCharArray();
        char[] pattern = needle.toCharArray();
        int n = text.length;
        int pLength = pattern.length;
        if (pLength == 0)
            return 0;
        int[] fail = computeFailKMP(pattern);
        int runner = 0;
        int matchIndex = 0;
        while (runner < n) {
            if (text[runner] == pattern[matchIndex]) {
                if (matchIndex == pLength - 1)
                    return runner - matchIndex;
                runner++;
                matchIndex++;
            } else if (matchIndex > 0) {
                matchIndex = fail[matchIndex - 1];
            } else {
                runner++;
            }
        }
        return -1;
    }

    // a b a a b a b a
    // 0 0 1 1 2 3 2 3
    private int[] computeFailKMP(char[] pattern) {
        int length = pattern.length;
        int[] fail = new int[length];
        int runner = 1;
        int match = 0;
        while (runner < length) {
            if (pattern[runner] == pattern[match]) {
                fail[runner++] = ++match;
            } else if (match > 0) {
                match = fail[match - 1];
            } else {
                runner++;
            }
        }
        return fail;
    }

}
