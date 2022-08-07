// Time Complexity : O(m+n) //length of both the string 
// Space Complexity : O(l)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: No

//kmp algorithm 
class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if(m <n) return -1;
        int i = 0; //hay ptr
        int j = 0; //needle ptr
        int [] lps = lps(needle);
        while(i < m){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
                if(j == n){
                    return i - n;
                } 
            } else if(haystack.charAt(i) != needle.charAt(j) && j > 0){
                j = lps[j-1];
            } else if(haystack.charAt(i) != needle.charAt(j) && j == 0){
                i++;
            }
        }
        return -1;
    }
    private int [] lps(String needle){
        int [] lps = new int[needle.length()];
        lps[0] = 0;
        int j = 0;
        int i = 1;
        
        //
        while( i < needle.length()){
            //case 1
            if(needle.charAt(i) == needle.charAt(j)){
                j++; // j gives me length of longest prefix window
                lps[i] = j; 
                i++;
            } else if(needle.charAt(i) != needle.charAt(j) && j > 0){
                j = lps[j-1];
            } else if(needle.charAt(i) != needle.charAt(j) && j == 0){
                lps[i] = 0;
                i++;
            }
        }
        return lps;
    }
}


/*
//brute force
class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        int i = 0; //hay ptr
        int j = 0; //needle ptr
        while( i <= m - n){
            if(haystack.charAt(i) == needle.charAt(j)){
                int k = i;
                while(haystack.charAt(k) == needle.charAt(j)){
                    k++; j++;
                    if( j == n) return i;
                }
                j = 0;
            }
            i++;
        }
        return -1;
    }
}
*/