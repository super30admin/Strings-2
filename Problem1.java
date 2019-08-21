// Time Complexity :O(N) -> N - length of  haystack
// Space Complexity :O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. Start from first character of haystack and check if it's equal to needle's first character. Else move on to next character in haystack. 
// 2. Now check each character of haystack and needle . If all needle's characters are found in same order return character in haystack 
//    where search was started.
// 3.Else move on to next character in haystack where search was started. Do this till needle is found or charcter's position in haystack is equal
//   to haystack's length minus needle's length.
public class strStr {
    public static int strStr(String haystack, String needle) {
        if(needle .length() == 0)    return 0;
        if(needle.length()>haystack.length())   return -1;
        int i = 0,j=0;
        while(i<=haystack.length()-needle.length()){
            if(haystack.charAt(i) == needle.charAt(j)){
                int temp = i;
                while(j<needle.length()){
                    if(haystack.charAt(i) != needle.charAt(j))
                        break;
                    i++;
                    j++;
                }
                if(j==needle.length())
                    return i-needle.length();
                j = 0;
                i = temp+1;
            }
            else
                i++;
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "issip";
        System.out.print(strStr(haystack,needle));
    }
}
