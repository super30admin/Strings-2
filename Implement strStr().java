// Time Complexity : O(m+n)
// Space Complexity : O(n);
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int strStr(String haystack, String needle) {
        //edge
        if(needle.length() == 0) return 0;
        //set m and n 
        int m = haystack.length();
        int n = needle.length();
        //create an empty array which will be filled with lps fucntion
        int [] lps = lps(needle);
        //set i and j pointers
        int i = 0; int j = 0;
        //set while loop to go over haystack array
        while(i < m){
            //case1 if they are the same character
            if(needle.charAt(j) == haystack.charAt(i)){
                //increment both pointers to move forward
                i++;
                j++;
                //check if j has gone out of bounds
                if(j == n){
                    return i - n;
                }
            }
            //case2 both characters are not equal and j > 0
            else if(j > 0 && needle.charAt(j) != haystack.charAt(i)){
                //just set j 
                j = lps[j-1];
            }
            //case3  both characters are not equal and j == 0
            else if(j == 0 && needle.charAt(j) != haystack.charAt(i)){
                //just increment i 
                i++;
            }
        }
        return -1;
    }
    
    //create the lps function
    private int [] lps(String needle){
        //make the lps array of size needle
        int [] lps = new int[needle.length()];
        //set the 0th index to have 0 
        lps[0] = 0;
        //set our two poitners
        int j = 0;
        int i = 1;
        //start a while loop that goes through the whole needle string
        while(i < needle.length()){
            //case1 if they are the same character
            if(needle.charAt(j) == needle.charAt(i)){
                //increase j
                j++;
                //add that j value into the index of i
                lps[i] = j;
                //increment i
                i++;
            }
            //case2 if the characters are not the same but not at 0 index
            else if(j > 0 && needle.charAt(j) != needle.charAt(i)){
                //just move j back an index to decrease windo
                j = lps[j-1];
            }
            //case3 if the characters are not the same but at 0 index
            else if(j == 0 && needle.charAt(j) != needle.charAt(i)){
                //make the index at lps i equal to 0
                lps[i] = 0;
                //move i index
                i++;
            }
        }
        //return the array
        return lps;
    }
}