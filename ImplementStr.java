// o(n) time || o(1) space
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        if (needle.length() > haystack.length())
            return -1;
        int hayIndex = 0;
        while (hayIndex != haystack.length()) {
            int i = hayIndex;
            int j = 0;
            while (j < needle.length() && i < haystack.length() && 
                   haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }
            if (j == needle.length())
                return hayIndex;
            hayIndex++;
        }
        return -1;
    }
}
