//time O(n)
//space O(1)

class Solution {
    public int strStr(String haystack, String needle) {
        int n = needle.length();
        int m = haystack.length();
        if(n > m) return -1;
        long hash = 0l;
        for(int i = 0; i < n; i++) {
            char in = needle.charAt(i);
            hash = hash * 26 + (in - 'a' + 1);
        }
        long kl = (long)Math.pow(26, n - 1);
        long currHash = 0l;
        for(int i = 0; i < m; i++) {
            if(i >= n) {
                //outgoing char
                char out = haystack.charAt(i - n);
                currHash = currHash - (long)(out - 'a' + 1) * kl;
            }
                
                //incoming char
                char in = haystack.charAt(i);
                currHash = currHash * 26 + (in - 'a' + 1);
                if(currHash == hash) return i - n + 1;
            
        }
        return -1;
    }
}
