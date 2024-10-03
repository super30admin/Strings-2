//time: O(m*n) space: O(1)
class Solution {
public:
    int strStr(string haystack, string needle) {
        int h = haystack.size();
        int n = needle.size();
        if(n > h) return -1;
        int h1;
        int n1;
        for(int i = 0; i <= h-n; i++) {
            if(haystack[i] == needle[0]) {
                n1 = 1;
                h1 = i+1;
                while(n1 < n && haystack[h1] == needle[n1]) {
                    n1++;
                    h1++;
                }
                if(n1 == n) return i;
            }
        }
        return -1;
    }
};