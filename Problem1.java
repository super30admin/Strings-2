// Problem1  Implement strStr() (https://leetcode.com/problems/implement-strstr/)

//Time complexity O(hlen (hlen - nlen)) 
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.isEmpty()) return 0;
        
        int hlen = haystack.length();
        int nlen = needle.length();
        for(int i = 0; i < hlen - nlen + 1; i++){
             if(haystack.substring(i, i + nlen).equals(needle)) return i;           
        }
        return -1;
    }
}

// KMP
//Time complexity O(slength + plength) 
// Space O(plength) 
// where slength -  string length and plength = pattern length
class Solution {
    public int strStr(String haystack, String needle) {
        //System.out.print(Arrays.toString(computePI("issip")));
        if(needle.isEmpty() && haystack.isEmpty()) return 0;
        if(needle.isEmpty()) return 0;
        // KMP
        //populate prefix-suffix array
        int[] pi = computePI(needle);
        
        int i = 0, j = 0, hlen = haystack.length(), nlen = needle.length();
        
        while(i < hlen){
           
            if(haystack.charAt(i) == needle.charAt(j)){
                // match
                j++;
                i++;
                
                
            }
            if(j == nlen){
                return i - j;
            }
            
            if(i < hlen && haystack.charAt(i) != needle.charAt(j)){
                // no match
                if(j > 0){
                    j = pi[j - 1]; 
                }else{
                    i++;
                }
            }
            
            
            
            
             
        }
        
        return -1;
    }
    //Populate prefix and suffix array
    private int[] computePI(String pattern) { 
        int n = pattern.length();
        int[] pi = new int[n];
        pi[0] = 0;
    
        int j = 0, i = 1;
    
        while(i < n) {
           
            if(pattern.charAt(i) == pattern.charAt(j)) {
                j++;
                pi[i] = j;
                i++;
            } else {
                
                if(j == 0) {
                    pi[i] = 0;
                    i++;
                } else {
                    j = pi[j-1];
                }
            }
        }
    
        return pi;
    }
}
  
