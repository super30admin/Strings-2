class Solution {// Time of O(N+M) and space of O(1)
    public int strStr(String haystack, String needle) {
        int i = 0, j = 0 ;
        int n = haystack.length();
        int m = needle.length();
        //Base case
        if(m == 0)
            return 0;
        
        int[] lps = helper(needle);
        
        while(i< n){
            //Case 1
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }
            //found the needle
            if(j == m) return i-j;
            
            if(i<n && haystack.charAt(i) != needle.charAt(j)){
                //start of the needle 
                if(j == 0){
                    i++;
                }else{
                    j = lps[j - 1];
                }
                // partial match in the needle
            }
        }
        return -1;
    }
    private int[] helper(String needle){
        int j = 0;
        int i = 1;
        int[] lps = new int[needle.length()];
        lps[0] = 0;
        while(i< needle.length()){
            if(needle.charAt(i) == needle.charAt(j)){
                j++;
                lps[i] = j ;
                i++;
            }else{
                if(j ==0){
                    lps[i] = j;
                    i++;
                }else{
                    j = lps[j-1];
                }
            }
        }
        return lps ;
    }
}