//Time : O(m*n)
//Space : O(1)

class Solution {
    public int strStr(String haystack, String needle) {
        int i = 0;
        int j = 0;
        while (i <= haystack.length() - needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                int k = i;
                while (haystack.charAt(k) == needle.charAt(j)) {
                    k++;
                    j++;
                    if (j == needle.length())
                        return i;
                }
                j = 0;
            }
            i++;
        }
        return -1;

    }
}