// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
/*
 * Using in-built function.
 * or checking if the substring exists in the string
 */
class Solution {
    public int strStr(String haystack, String needle) {
        //in-built method, returns the index within this string of the first occurrence of the specified substring.
        //return haystack.indexOf(needle);
        if(haystack.length() < needle.length()) return -1;
        int j = 0;
        for(int i = 0; i < haystack.length(); i++){
            j = i + needle.length();
            if(j <= haystack.length() && haystack.substring(i,j).equals(needle)) return i;
        }
        
        return -1;
    }
}