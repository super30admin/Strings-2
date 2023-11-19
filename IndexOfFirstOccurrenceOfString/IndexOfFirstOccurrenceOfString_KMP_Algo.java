/* Time Complexity : O(m+n) 
*   m - length of source string - haystack 
*   n - length of patern string - needle */
/* Space Complexity : O(n) 
*   lps array length */
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if(n > m) return -1;
        int[] lps = lpsArr(needle);
        int i = 0;
        int j = 0;

        while(i < m){
            char cSrc = haystack.charAt(i);
            char cPat = needle.charAt(j);
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
                if(j == n){
                    return i - n;
                }
            } else{ //cSrc != cPat
                if(j > 0){
                    j = lps[j - 1];
                }else if(j == 0){
                    i++;
                }
           }
        }

        return -1;
    }

    private int[] lpsArr(String pattern){
        int n = pattern.length();
        int[] lps = new int[n];
        lps[0] = 0;
        int i = 1;
        int j = 0;
        while(i < n){
            char cJ = pattern.charAt(j);
            char cI = pattern.charAt(i);
            if(cJ == cI){
                j++;
                lps[i] = j;
                i++;
            }
            else{//cJ != cI
                if(j > 0){
                    j = lps[j - 1];
                }else if(j == 0){
                    lps[i] = 0;
                    i++;
                }
           }
        }
        return lps;
    }
}