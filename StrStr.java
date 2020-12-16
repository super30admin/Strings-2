// Time Complexity :  O(M + N) 
// Space Complexity : O(m)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

//KMP 
public int strStr(String haystack, String needle) {
 
    if(needle.length()==0)
        return 0;
        
   int patternLen = needle.length();
   
   // calculate longest prefix suffix
   int lps[] = new int[patternLen+1];
   int j=0;
   for(int i=1; i<patternLen; i++) {
	   while(j>0 && needle.charAt(i)!=needle.charAt(j)) {
		   j=lps[j-1];
	   }
	   
	   if(needle.charAt(i)==needle.charAt(j)) 
		   j++;
		   
	   lps[i]=j;	  
   }
      
   int i=0; j=0;
   while(i<haystack.length()) {
	   if(haystack.charAt(i)==needle.charAt(j)) {
		   i++; j++;
	   }
	   
	   if(j==patternLen) {
		   return (i-j);
	   }
	   
	   else if(i<haystack.length() && haystack.charAt(i)!=needle.charAt(j)) {
		   if(j!=0) 
			   j=lps[j-1];
		   else 
			   i++;
	   }   
   }
   
    return -1;
    
}
//Brute Force
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0; 
        int i = 0;// string pointer
        while(i < haystack.length() - needle.length() + 1){
            
            if(needle.charAt(0) == haystack.charAt(i)){
                int j = 0; // pattern pointer
                int k = i;
                while(k < haystack.length() && needle.charAt(j++) == haystack.charAt(k++)){
                    if(j == needle.length())
                        return i;
                }
            }
            i++;
        }
        return -1;
    }
}