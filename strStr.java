// Time Complexity : O(m+n)
// Space Complexity :O(n)
//m is the length of haystack string
//n is the length of needle string
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

//Optimised Approached using KMP algorithm
class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();

        if( m < n ) return -1;

        //haystack ptr
        int i = 0;
        //needle ptr
        int j = 0;

        int lps[] = lps(needle);

        while(i < m){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;

                if(j == n)
                    return i-n;
            }
            else if(haystack.charAt(i) != needle.charAt(j) && j > 0){
                j = lps[j-1];
            }
            else if(haystack.charAt(i) != needle.charAt(j) && j == 0){
                i++;
            }
        }
        return -1;
    }

    private int[] lps(String needle){
        int i = 1;
        int j = 0;

        int[] lps = new int[needle.length()];
        lps[0] = 0;

        while(i < needle.length()){
            if(needle.charAt(j) == needle.charAt(i)){
                j++;
                lps[i] = j;
                i++;
            }
            else if(needle.charAt(j) != needle.charAt(i) && j > 0){
                j = lps[j-1];
            }
            else if(needle.charAt(j) != needle.charAt(i) && j == 0){
                lps[i] = 0;
                i++;
            }
        }
        return lps;
    }
}

//Brute Force
//TC: O(m*n)
// m is the length of haystack string
//n is the length of  needle string
class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();

        //haystack pointer
        int i = 0;

        //needle pointer
        int j = 0;

        while(i <= m-n){
            if(haystack.charAt(i) == needle.charAt(j)){
                int k = i;
                while(haystack.charAt(k) == needle.charAt(j)){
                    k++;
                    j++;

                    if(j == n) return i;
                }
                j = 0;
            }
            i++;
        }
        return -1;
    }
}