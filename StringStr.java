// Time Complexity : O(n * n )
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO
public class StringStr {
    public int strStr(String haystack, String needle) {
        for(int i=0; i <= haystack.length()- needle.length(); i++){
            if(haystack.charAt(i) == needle.charAt(0))
                if(haystack.substring(i, i+needle.length()).equals(needle))
                    return i;
        }
        return -1;
    }
}