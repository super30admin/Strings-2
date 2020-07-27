//Time Complexity : O(m+n) m is the size of the String haystack and n is the size of the needle string
//Space : O(n) where n is the size of the needle string
// On line 14 please check the error.



class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null) return -1;
        int m = needle.length(); int n = haystack.length();
        if(n==0) return 0;
        int[] lps = lps(needle);
        int i = 0; int j = 0;
        while(i<n){
            if(haystack.charAt(i) == needle.charAt(j)){//this line has out of bound error. I can't figure out, please help me.
                i++;j++;
            }
            else if(j == m) return i-m;
            
            else if( i<n && j > 0 && haystack.charAt(i) != needle.charAt(j) ){
                j = lps[j-1];
            }
            else if ( i<n && j==0 && haystack.charAt(i) != needle.charAt(j) ){
                i++;
            }
        }
        return -1;
    }
    
    private int[] lps(String needle){
        int lps[] = new int[needle.length()];
        int i = 1; int j =0;
        while(i<needle.length()){
           if(needle.charAt(i) == needle.charAt(j)){
               j++;
               lps[i] = j;
               i++;
           }
           else if(j>0 && needle.charAt(i) != needle.charAt(j) ){
               j = lps[j-1] ;
           }
           else if(j==0 && needle.charAt(i) != needle.charAt(j)){
               lps[i] =0 ;
               i++;
           }
       }
        return lps;
    }
}