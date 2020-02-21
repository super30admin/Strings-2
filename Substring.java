/*
 * Leetcode link : https://leetcode.com/problems/implement-strstr/
 * Time complexity : O(m+n)
 * Space complexity : O(m) --> length of needle
 * 
 */


class Solution {
    public int strStr(String haystack, String needle) {
        
        if(needle == null || needle.length() == 0)
                return 0;
        
        int[] lps = calculateLpsArray(needle);
        
        System.out.println(Arrays.toString(lps));
        
        int i = 0;
        int j = 0;
        
        while(i < haystack.length()){
            
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }
            
            if(j == needle.length()){
                return (i-j);
            }
           
            
            if(i < haystack.length() && j > 0 && haystack.charAt(i) != needle.charAt(j)){
                j = lps[j-1];
            }else if(i < haystack.length() && j == 0 && haystack.charAt(i) != needle.charAt(j)){
                i++;
            }
            
            
        }
        
        return -1;
        
    }
    
    private int[] calculateLpsArray(String needle){
        
        
        int[] lps = new int[needle.length()];
        
        lps[0] = 0;
        int i = 1;
        int j = 0;
        while(i < needle.length()){
            
            if(needle.charAt(i) == needle.charAt(j)){
                j++;
                lps[i] = j;
                i++;
            }else if(needle.charAt(i) != needle.charAt(j) && j > 0){
                j = lps[j-1];
            }else if(needle.charAt(i) != needle.charAt(j) && j == 0){
                lps[i] = 0;
                i++;
            }
        }
        
        return lps;
    }
}