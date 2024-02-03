// Time Complexity  : O(n+m)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class indexOfFirstOccurenceInString {
    // Implementing KMP Algo
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();

        if (n > m)
            return -1;

        int[] lps = lps(needle);
        int i = 0; // haystack ptr
        int j = 0; // needle ptr

        while (i < m) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == n) {
                    return i - n;
                }
            } else if (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = lps[j - 1];
            } else if (j == 0 && haystack.charAt(i) != needle.charAt(j)) {
                i++;
            }
        }
        return -1;
    }

    public int[] lps(String needle) {
        int[] lps = new int[needle.length()];
        lps[0] = 0;

        int i = 1;
        int j = 0;

        while (i < needle.length()) {
            char chj = needle.charAt(j);
            char chi = needle.charAt(i);

            if (chj == chi) {
                j++; // prefix window expand
                lps[i] = j;
                i++;
            } else {
                if (j == 0) {
                    lps[i] = j;
                    i++;
                } else {
                    j = lps[j - 1];
                }
            }
        }
        return lps;
    }
}

/*
 * Rabin Karp (Rolling Hash)
 * public int strStr(String haystack, String needle) {
 * int m = haystack.length();
 * int n = needle.length();
 * 
 * if(n > m) return -1;
 * 
 * BigInteger hash = BigInteger.ZERO;
 * BigInteger k = BigInteger.valueOf(26);
 * 
 * for(int i=0;i<n;i++) {
 * char c = needle.charAt(i);
 * hash = hash.multiply(k).add(BigInteger.valueOf(c-'a'+1));
 * }
 * 
 * BigInteger hash2 = BigInteger.ZERO;
 * 
 * for(int i=0;i<m;i++) {
 * 
 * if(i >= n) {
 * hash2 = hash2.mod(k.pow(n-1));
 * }
 * 
 * char in = haystack.charAt(i);
 * hash2 = hash2.multiply(k).add(BigInteger.valueOf(in-'a'+1));
 * 
 * if(hash.equals(hash2)) return i-n+1;
 * }
 * return -1;
 * }
 */
