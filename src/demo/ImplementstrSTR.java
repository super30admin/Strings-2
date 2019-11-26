package demo;

class Solution {
    public int strStr(String haystack, String needle) {
       if(needle == "" || needle == null ||
          needle.length() ==0 ) return 0;
        if(haystack == "" || haystack == null ||
           haystack.length() == 0 || haystack.length() < needle.length()) return -1;
        
         char n = needle.charAt(0);
       
        for(int i=0; i < haystack.length(); i++){
            
            if(haystack.charAt(i)== n){
                return i;
            }
        }
        
        return -1;
    }
}