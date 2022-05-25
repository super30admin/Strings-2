// Time Complexity : O(n)
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0 || needle == null) return 0;
        
        int[] lps = new int[needle.length()];
        
        lps = getLps(needle);
        
        int p1 = 0, p2 = 0;
        
        while(p1 < haystack.length()) {
            if(haystack.charAt(p1) == needle.charAt(p2)) {
                p1++;
                p2++;
                
                if(p2 == needle.length()) {
                    return p1 - needle.length();
                }
            } 
            else if(haystack.charAt(p1) != needle.charAt(p2) && p2 > 0) {
                p2 = lps[p2-1];
            }
            else if(haystack.charAt(p1) != needle.charAt(p2) && p2 == 0) {
                p1++;
            }
        }
        
        return -1;
    }
    
    public int[] getLps(String needle) {
        
        int left = 0, right = 1;
        int[] lps = new int[needle.length()];
        lps[0] = 0;
        
        while(right < needle.length()) {

            if(needle.charAt(left) == needle.charAt(right)) {
                left++;
                lps[right] = left;
                right++;
            } 
            else if(needle.charAt(left) != needle.charAt(right) && left > 0) {
                left = lps[left - 1];
            }
            else if(needle.charAt(left) != needle.charAt(right) && left == 0) {
                lps[right] = 0;
                right++;
            }           
        }

        return lps;
    }
}