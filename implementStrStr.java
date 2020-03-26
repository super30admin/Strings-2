// Time Complexity : O((N-L)L)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : After class solution


// Your code here along with comments explaining your approach

class Solution {
    public int strStr(String haystack, String needle) {
       // System.out.println(Arrays.toString(computePI("aaabaab")));     
        
        //base check        
        if(needle.length() == 0) return 0;
        
        int m = haystack.length(), n = needle.length();
        int[] pi = computePI(needle);
        
        int i = 0, j =0;
        
        while(i< m){
            //characters matches
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
                
                if(j == n){
                    return i - j;
                }
            }else{
                if(j==0){
                    i++;
                }else{
                    j = pi[j-1];
                }
            }
        }
        
        
        return -1;
        
    }