/*
 * TC: O((m-n)*n)
 * SC: O(1)
 */
public class FindSubstring {
    public int strStr(String haystack, String needle) {
        int i, j, k;
        int m = haystack.length();
        int n = needle.length();

        for(i = 0; i <= m - n; i++) {
            // checks both start and end indices of needle in haystack
            // to reduce the number of computations
            if(haystack.charAt(i) == needle.charAt(0) && (i+n) <= m && haystack.charAt(i+n-1) == needle.charAt(n-1)) {
                // compares from both ends
                for(j = 0, k = (n - 1); j <= n/2 && k >= n/2; j++, k--) {
                    if(haystack.charAt(i+j) != needle.charAt(j) || haystack.charAt(i+k) != needle.charAt(k)) {
                        break;
                    }
                }
                // if we crossed at the center the substring was found
                if(j > k) return i;
            }
        }
        return -1;
    }
}