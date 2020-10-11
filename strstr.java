// TC - O(N)
// SC - O(N)
class Solution {
    public int strStr(String haystack, String needle) {
        
        int[] lps = new int [needle.length()];
        
        if(needle.length() == 0) return 0;
        
        lps = getlps(needle);
        
        int i =0, j =0;
        while (i < haystack.length()){
            char ch1 = haystack.charAt(i);
            char ch2 = needle.charAt(j);
            if(ch1 == ch2){
                j++;
                i++;
                 
            }
            else if(j > 0 && ch1 != ch2){
                j = lps[j-1];
            }
            else {
                i++;
            }
            if(j == needle.length()){
                return i-j;
            }
        }
        return -1;
        
    }
    private int[] getlps(String needle){
        int[] lps = new int [needle.length()];
        int i =1, j =0;
        lps[0] =0;
        while (i < needle.length()){
            char ch1 = needle.charAt(i);
            char ch2 = needle.charAt(j);
            if(ch1 == ch2){
                j++;
                lps[i] = j;
                i++;
            }
             else if(j > 0 && ch1 != ch2){
                j = lps[j-1];
            }
            else {
                lps[i] = 0;
                i++;
            }
        }
        return lps;
    }
}