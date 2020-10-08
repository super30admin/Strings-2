//Time :O(N)
//space O(N)
class Solution {
    public int strStr(String haystack, String needle) {

        if (needle.length() == 0) {
            return 0;
        }
        int[] LPS = calLPS(needle);
        int i = 0, j = 0;

        while (i < haystack.length()) {
            char ch_i = haystack.charAt(i);
            char ch_j = needle.charAt(j);

            // case1
            if (ch_i == ch_j) {
                i++;
                j++;
            }
            // case 2
            if (j == needle.length())
                return i - j;
            else if (j > 0 && ch_i != ch_j) {
                j = LPS[j - 1];
            } else if (j == 0 && ch_i != ch_j) {
                i++;
            }

        }

        return -1;

    }

    int[] calLPS(String needle) {
        int[] LPS = new int[needle.length()];

        int i = 1;
        int j = 0;
        while (i < needle.length()) {
            char ch_i = needle.charAt(i);
            char ch_j = needle.charAt(j);
            // case1
            if (ch_i == ch_j) {

                j++;
                LPS[i] = j;
                i++;
            }

            else if (j > 0 && ch_i != ch_j) {
                j = LPS[j - 1];
            } else if (j == 0 && ch_i != ch_j) {
                LPS[i] = 0;
                i++;
            }
        }

        return LPS;
    }
}