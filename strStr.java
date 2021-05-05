// Runtime complexity - O(n) where n is the length of the haystack
// Space complexity - O(1)

class Solution {
    public int strStr(String haystack, String needle) {
        int i=0;
        int j=0;
        int m=haystack.length();
        int n=needle.length();
        int result=-1;
        if(n==0)
            return 0;
        while(i<m && j<n)
        {
            if(needle.charAt(j) == haystack.charAt(i))
            {
                if(j==0)
                {
                    result=i;
                }
                j++;
                i++;
            }
            else if(result!=-1 && needle.charAt(j) != haystack.charAt(i))
            {
                j=0;
                i=result+1;
                result=-1;
            }
            else
                i++;
        }
        if(j==n)
        {
            return result;
        }
        else
            return -1;
    }
}
