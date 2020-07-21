// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class strStr {
    public int strStr(String haystack, String needle) {
        int hLen = haystack.length();
        int nLen = needle.length();

        if(nLen > hLen){
            return -1;
        }

        if(haystack.equals(needle)){
            return 0;
        }

        int l = 0;
        int r = l + nLen;

        while(l < hLen && r <= hLen){
            System.out.println("l" +l);
            if(haystack.substring(l,r).equals(needle)){
                return l;
            }

            l++;
            r = l + nLen;
        }

        return -1;
    }
}
