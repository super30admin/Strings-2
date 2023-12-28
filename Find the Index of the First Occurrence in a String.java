// Time Complexity :O(m-n+1)*n
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int strStr(String haystack, String needle) {
        int m=haystack.length();
        int n=needle.length();
        if(m<n)
        return -1;

        int i=0,j=0;
        while(i<=m-n)
        {
            int k=i;
            while(haystack.charAt(k)==needle.charAt(j))
            {
                k++;
                j++;

                if(j==n)
                return i;

            }
            i++;
            j=0;

        }
        return -1;
    }
}