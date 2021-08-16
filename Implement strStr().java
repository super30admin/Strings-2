class Solution {
    public int strStr(String haystack, String needle) {

        if(haystack == null || needle == null || needle.length() > haystack.length()) return -1;

        int len = haystack.length(), i = 0, j = 0, pos = 0;

        while(i < len && j < needle.length())
        {
            if(haystack.charAt(i++) == needle.charAt(j))  j++;

            else
            {
                i = i - j;
                j = 0;
                pos = i;
            }
        }

        return j == needle.length()? pos : -1;
    }
}
