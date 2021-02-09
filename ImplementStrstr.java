// Time Complexity : O(n*m) where n is length of haystack and m is length of needle
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public class ImplementStrstr {
    class Solution {
        public int strStr(String haystack, String needle) {
            if(haystack.length()==0 && needle.length()==0 ) return 0;
            int j=0;
            for(int i=0;i<haystack.length();i++)
            {
                while(i<haystack.length() && j<needle.length() && haystack.charAt(i)==needle.charAt(j))
                {
                    i++;
                    j++;
                }
                if(j==needle.length())
                {
                   return i-j;
                }
                i=i-j; // set i to original position to check next possiblity
                j=0;  // set j to 0 
                
            }
            return -1;
        }
    }    
}
