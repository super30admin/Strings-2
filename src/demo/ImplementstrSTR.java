package demo;

//Time: o(mn)
//Space: O(1)
// Can be optimized in linear time

class Solution {
    public int strStr(String haystack, String needle) {
       if(needle == "" || needle == null || needle.length() ==0 ) return 0;
        if(haystack == "" || haystack == null || haystack.length() == 0 || haystack.length() < needle.length()) return -1;
        
        for(int j=0 ; j < needle.length(); j++) {
         char n = needle.charAt(j);
       
         //linear searching
        for(int i=0; i < haystack.length(); i++){
            
            if(haystack.charAt(i)== n){
                return i;
            }
        }
        }
        
        return -1;
    }
}