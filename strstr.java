// Time: O(2n)
// Space: O(1)
// Idea here is to use Knuth Morris Pratt algorithm to identfy longest common prefx suffix and matching the pattern in both strings to find the starting point of pattern matched. 
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length()> haystack.length()) return -1;
        if(needle.length()==0) return 0;
        int i = 0; int j = 0;
        int[] lps = lps(needle);
        while(i<haystack.length()) {
            if(haystack.charAt(i)==needle.charAt(j)) {
                i++; j++;
                if(j==needle.length()) return i-needle.length();
            } else if(haystack.charAt(i)!=needle.charAt(j) && j>0) {
                j = lps[j-1];
            } else if(haystack.charAt(i)!=needle.charAt(j) && j==0) {
                i++;
            }
        }
        return -1;
    }
    
    public int[] lps(String needle) {
        int[] lps = new int[needle.length()];
        lps[0] = 0;
        int i = 1; int j = 0;
        while(i<needle.length()) {
            if(needle.charAt(i)==needle.charAt(j)) {
                lps[i++] = ++j;
            } else if(needle.charAt(i)!=needle.charAt(j) && j>0) {
                j = lps[j-1];
            } else if(needle.charAt(i)!=needle.charAt(j) && j==0) {
                lps[i++] = 0;
            }
        }
        return lps;
    }
}