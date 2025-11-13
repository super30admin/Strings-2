/*
* Approach: KMP Pattern Matching Algorithm
 * The idea is to search for the substring `needle` inside `haystack` efficiently without re-checking previously matched characters.
 * KMP uses a preprocessing step to compute an LPS (Longest Prefix Suffix) array for the pattern (`needle`). The LPS array stores, for each position, the length of the longest prefix that is also a suffix up to that point.
 * When a mismatch occurs during the search, KMP uses this LPS array to know where to resume matching — skipping redundant comparisons.
 * TC: O(m+n) -> prepocessing + searching in the haystack
 * SC: O(m) -> for LPS array which is the length of the needle
 */
class Solution {
    int[] lps;
    int n;

    public int strStr(String haystack, String needle) {
        this.n = needle.length();
        this.lps = new int[n];
        //Preprocess the pattern to build LPS array
        preprocess(needle);
        int i = 0, j = 0;

        while (i < haystack.length()) {
            // Case 1: Characters match -> move both pointers forward
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                //if full match found -> return start index
                if (j == n) {
                    return i - j;
                }
            }
            //if mismatch happens after some matches move j to the last known prefix-suffix position 
            else if (haystack.charAt(i) != needle.charAt(j) && j > 0) {
                j = lps[j - 1];
            }
            //if mismatch happens at the beginning, move i forward
            else {
                i++;
            }
        }

        return -1;
    }

    private void preprocess(String needle) {
        lps[0] = 0; // first element has no proper prefix/suffix
        int i = 1; // current index being processed
        int j = 0; // length of the previous longest prefix suffix

        while (i < n) {
            // char match -> expand the prefix window
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
                lps[i] = j;
                i++;
            }
            //mismatch, fall back to using previous LPS 
            else if (needle.charAt(i) != needle.charAt(j) && j > 0) {
                j = lps[j - 1];
            }
            //if no prefix to fallback, return to 0 
            else {
                lps[i] = 0;
                i++;
            }
        }
    }
}
