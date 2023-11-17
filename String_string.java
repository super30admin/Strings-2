
// Time Complexity :O(n)
// Space Complexity : O(m) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



class Solution {
    public int strStr(String haystack, String needle) {
    int m = haystack.length();
    int n = needle.length();
    if(n > m) return -1;
    int[] lps = lps(needle);
    int i = 0; //haystack ptr
    int j = 0; //needle ptr
    while(i<m){
        if(haystack.charAt(i) == needle.charAt(j)){
            i++; j++;
            if(j== n ){
                return i-n;
            }
        } else if( j> 0 && haystack.charAt(i) != needle.charAt(j)){
            j= lps[j-1];
         
        } else if( j== 0 && haystack.charAt(i) != needle.charAt(j) ){
            i++;
        }
    }
      return -1;  
    }
    
      
    private int[] lps(String needle){
      int[] lps = new int[needle.length()];
      lps[0] = 0;
      int i=1; int j = 0;
      while(i< needle.length()){
        char chj = needle.charAt(j);
        char chi = needle.charAt(i);
        if(chj == chi){
            j++;
            lps[i] = j;
            i++;
        }   else if(j> 0 && chj != chi){
            j= lps[j-1];
            
        } else if(j== 0 && chj != chi){
          lps[i] = 0;
          i++;
      }
      }
       return lps;  
    }
}
