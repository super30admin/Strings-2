
// Time Complexity : O(n) n are the length of haystack string
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
traverse the haystack string with all the possible substrings of length m(length of the needle string) and 
complared with needle string. if equal then return the starting index of the matched substring
class Solution {
    public int strStr(String haystack, String needle) {
        int i = 0;
        int n = needle.length();
        int j = n;
        while(i<haystack.length() && j<=haystack.length()){
            String h = haystack.substring(i,j);
           
            if(h.equals(needle)) return i;
            else{
                i++;
                j = i+n;
            }
        }
        return -1;
    }
}