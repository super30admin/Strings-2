
public class Solution {
      public int strStr(String haystack, String needle) {
        
          int len = haystack.length()-needle.length()+1; // Len variable created to run the loop over Haystack to avoid Array Index out of bounds in case of needle is not found.
          
        if(needle.length() == 0) return 0;  // If needle length is 0, empty string return 0.
        if(haystack.length()<needle.length()) return -1;    // If haystack smaller than needle, cannot find so return -1.
          
        for(int i = 0; i<len; i++)  // Run loop till Len and not Haystack.length() to avoid run time error.
        {
            if(haystack.substring(i,i+needle.length()).equals(needle)){
                return i;
            }
        }
    
    return -1;
    }
}