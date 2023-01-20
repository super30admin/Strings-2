//tc : o(n)
//sc : O(1)
//run successfull
//no problems

//compared the needle with the all the subsequences;
class Solution {
    public int strStr(String haystack, String needle) {
        int len = needle.length();
        for (int i = 0; i < haystack.length() - len + 1; i++) {
            if (needle.equals(haystack.substring(i, i + len)))
                return i;
        }
        return -1;
    }
}