
// Time Complexity : O(M+N)
// Space Complexity : O(N) //the needle length
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0)
            return 0;
        
        if(haystack.length() < needle.length())
            return -1;
        
        int[] lps = lps(needle);
        
        int i = 0, j = 0, m = haystack.length(), n = needle.length();
        
        while(i < m){
            if(haystack.charAt(i) == needle.charAt(j)){
                j++;
                i++;
                
                //reached end and both match so return first index
                if(j == n)  return i - n;
            }
            else{
                //j > 0
                if(j > 0)
                    j = lps[j - 1];
                else if(j == 0)
                    i++;
            }
            
        }
        return -1;
    }
    
    private int[] lps(String needle){
        int[] lps = new int[needle.length()];
        
        int i = 1, j = 0;
        
        while(i < needle.length()){
            
            //i and j are equal
            if(needle.charAt(i) == needle.charAt(j)){
                j++;
                lps[i] = j;
                i++; //extending the window
            }
            
            //char at i and j are not equal and j > 0
            else{
                
                //shrinking the prefix window
                if(j > 0){
                    j = lps[j - 1]; //squeeze window
                }
                else if(j == 0){
                    lps[i] =0;
                    i++;
                }
            }
        }
        return lps;
    }
}