// Time Complexity : O(m + n)
// Space Complexity : O(n)

class Solution {
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0)
            return 0;
        if(haystack == null || haystack.length() == 0)
            return -1;
        int i = 0;
        int j = 0;
        int[] lps = helper(needle); 
        while(i < haystack.length()){
            if(haystack.charAt(i) == needle.charAt(j)){
                j++;
                i++;
                if(j == needle.length()){
                    return i - needle.length();
                }
            }
            else if(haystack.charAt(i) != needle.charAt(j) && j > 0){
                j = lps[j - 1];
            }
            else if(haystack.charAt(i) != needle.charAt(j) && j == 0){
                i++;
            }
        }
        return -1;
    }
    
    private int[] helper(String needle){
        int[] lps = new int[needle.length()];
        int i = 1;
        int j = 0;
        while(i < needle.length()){
            if(needle.charAt(i) == needle.charAt(j)){
                j++;
                lps[i] = j;
                i++;
            }
            else if(needle.charAt(i) != needle.charAt(j) && j > 0){
                j = lps[j - 1];
            }
            else if(needle.charAt(i) != needle.charAt(j) && j == 0){
                lps[i] = 0;
                i++;
            }
        }
        return lps;
    }
}