// Time Complexity : O(N*M) , N = str1 length M = str2 length
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class ImplementStrStr {
    class Solution {
        public int strStr(String haystack, String needle) {
            if(needle == null || needle.length() == 0) return 0;
            if(haystack == null || haystack.length() == 0 || haystack.length() < needle.length()) return -1;

            int ptr1 = 0;

            while(ptr1< haystack.length()) {
                int ptr2 = 0;
                if(haystack.charAt(ptr1) == needle.charAt(ptr2)) {
                    int temp = ptr1;
                    while(haystack.charAt(ptr1) == needle.charAt(ptr2)) {
                        ptr1++;
                        ptr2++;

                        if(ptr2 == needle.length())
                            return temp;
                    }

                    ptr2 = temp;

                }
                ptr1++;
            }
            return -1;
        }
    }

}
