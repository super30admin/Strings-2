// Time Complexity : O(mn), m is length of haystack; n is length of needle
// Space Complexity :
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


//Brute Force 
//O(mn), m is length of haystack; n is length of needle
class Solution {
    public int strStr(String haystack, String needle) {
        //if needle is empty, return 0
        if(needle.length() == 0) return 0;
        
        //for ith char is haystack check
        for(int i = 0; i < haystack.length(); i++) {
            //if i + needle len >= haystack len (the neddle wont be present) 
            //so we can break
            if(i+needle.length() > haystack.length()) break;
            //for each char is needle
            for(int j = 0; j < needle.length(); j++) {
                //check if i+j char of haystack == j char of needle, 
                //if not break, else increment j
                if(haystack.charAt(i+j) != needle.charAt(j)) break;
                //if j reaches end of needle, then all chars of needle found in haystack
                //starting from ith position in haysatck, so return i
                if(j == needle.length()-1) return i;
            }
        } return -1;  //if needle not found in haysatck, return -1       
    }
}



////////////////

