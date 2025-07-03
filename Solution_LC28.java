//Time Complexity: O((n - m + 1) * m)
//        where n = haystack.length(), m = needle.length().
//(Each substring comparison takes O(m) time.)

// Space Complexity: O(1)

class Solution {
    public int strStr(String haystack, String needle) {

        for (int i = 0; i <= (haystack.length() - needle.length()); i++) {
            if (needle.equalsIgnoreCase(haystack.substring(i, i + needle.length())))
                return i;
        }
        return -1;
    }
}