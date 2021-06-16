// Time Complexity : O(N+M)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.equals(needle) || needle.equals("")) return 0;

        int[] lps = LPS(needle);
        int hl = haystack.length();
        int nl = needle.length();
        int i = 0;
        int j = 0;
        while(i < hl){
            char hc = haystack.charAt(i);
            char nc = needle.charAt(j);
            if(hc == nc){
                i++;
                j++;
                if(j == nl) return i-nl;
            }else{
                if(j > 0) j = lps[j-1];
                else i++;
            }
        }
        return -1;

    }
    private int[] LPS(String needle){
        int[] lps = new int[needle.length()];
        lps[0] = 0;
        int j = 0;
        int i = 1;
        while (i < lps.length){
            if(needle.charAt(i) == needle.charAt(j)){
                lps[i] = j + 1;
                j++;
                i++;
            }
            else{
                if(j>0)j = lps[j-1];
                else i++;
            }
        }
        return lps;
        
    }
}
