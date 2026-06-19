//Time Complexity: O(n + m)
//Space Complexity: O(1)

class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();

        long needleHash = 0;
        long posFac = (long)Math.pow(26, n);

        for(int i = 0; i < n; i++) {
            char ch = needle.charAt(i);
            needleHash = (needleHash * 26 + (ch - 'a' + 1));
        }

        long currHash = 0;

        for(int i = 0; i < m; i++) {
            char in = haystack.charAt(i);
            currHash = (currHash * 26 + (in - 'a' + 1));

            if(i >= n) {
                char out = haystack.charAt(i - n);
                currHash = (currHash - (posFac * (out - 'a' + 1)));
            }

            if(currHash == needleHash) {
                return i - n + 1;
            } 
        }

        return -1;
    }
}