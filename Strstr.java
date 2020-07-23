// Time Complexity - O(mn)
// Space Complexity - O(1)
// Brute force
class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if(m==0) return 0;
        int i=0;
        while(i < n) {
            int j = 0;
            int temp = i;
            while(temp < n && j < m) {
                if(haystack.charAt(temp)!=needle.charAt(j)) break;
                j++;
                temp++;
            }
            if(j==m) return i;
            i++;
        }
        return -1;
    }
}

// KMP
// Time - O(m+n) || Space - O(1) as it has max of 26 elements

// Perform KMP Alogo to avoid repetitive checks for indices in needle, where there is a prefix for given suffix.
// Create an lps array to indictate the presence of prefixes for a given suffix
class Solution {
    public int strStr(String haystack, String needle) {
        int i = 0, j = 0;
        int n = haystack.length(), m = needle.length();
        if(m == 0) return 0;
        int[] lps = lps(needle);
        while(i < n) {
            if(haystack.charAt(i) == needle.charAt(j)) {
                i++; j++;
            }
            if(j == m) return i-j;
            if(i < n && haystack.charAt(i) != needle.charAt(j)) {
                if(j > 0) {
                    j = lps[j-1];
                } else {
                    i++;
                }
            }
        }
        return -1;
    }
    
    private int[] lps(String needle) {
        int j = 0, i = 1;
        int[] lps = new int[needle.length()];
        lps[0] = 0;
        while(i < needle.length()) {
            if(needle.charAt(i) == needle.charAt(j)) {
                j++;
                lps[i] = j;
                i++;
            } else {
                if(j == 0) {
                    lps[i] = j;
                    i++;
                } else {
                    j = lps[j-1];
                }
            }
        }
        return lps;
    }
}