//KMP - algorithm
// Time Complexity : O(n) n is size of haystack
// Space Complexity : (m) m is size of needle
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//We are using the standard KMP algorithm to solve this
//We will first calculate the lps[] (longest prefix that is also suffix)
//Now we will start matching and incase of mismatch we will use lps[] to decide the part
//That is not required to be matched. We will return the start of first match

class Solution {
    
    public int strStr(String haystack, String needle) {
        int[] lps = new int[needle.length()];     
        int i = 0, j = 0;
        int n = haystack.length();
        int m =  needle.length();
        if(m == 0 )
            return 0;
        calculatelps(needle, lps);
        while(i < n){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }
            if(j == m){
                return i-m;
            }
            else if(i < n &&  haystack.charAt(i) != needle.charAt(j)){
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
            return -1;
    }
    private void calculatelps(String n, int[] lps){
        lps[0] = 0; 
        int i = 1;
        int len = 0;
        while(i < n.length()){
            if(n.charAt(i) == n.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }
            else{
                if(len != 0){
                    len = lps[len-1];
                }
                else{
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
}