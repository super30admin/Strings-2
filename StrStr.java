/*
 * TC: O(n+m). n:haystack.length and m:needle.length
 * SC: O(m), for storing Longest proper prefix.
 * 
 * Approach: I start by building LPS, then iterate though the haystack, whenever i 
 * get the matching character then i just incrrement my pointers i,j. In casematch not found,
 * i update my j to the value of my LPS[j-1]. As soon as, i find my j is length of neeedle,
 * i return the result as i - m.
 */


class Solution {
    public int strStr(String haystack, String needle) {
        int m = needle.length();
        int n = haystack.length();
        int prevLPS = 0, i = 1;

        int[] lps = new int[m];
        lps[0] = 0;

        while(i < m){
            if(needle.charAt(i) == needle.charAt(prevLPS)){
                lps[i] = prevLPS+1;
                i++;
                prevLPS++;
            }else{
                if(prevLPS == 0){
                    lps[i] = 0;
                    i++;
                }else{
                    prevLPS = lps[prevLPS - 1];
                }
            }
        }

        i = 0;
        int j=0;
        while(i < n){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }else{
                if(j == 0) i++;
                else j = lps[j-1];
            }
         if(j == m) return i - m;
        }
    return -1;
    }
}