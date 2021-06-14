class Solution {
    //Time O(haystack)
    //Space O(Needle)
    int ar[];
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0)
        {
            return 0;
        }
        int i = 0 , j = 0;
        ar = new int[needle.length()];
        ar[0] = 0;
        LPS(needle);
        while(i < haystack.length())
        {
            if(haystack.charAt(i) == needle.charAt(j))
            {
                i++;
                j++;
                if(j == needle.length())
                {
                    return i-j;
                }
            }
            else if(j > 0)
            {
                j = ar[j-1];
            }
            else
            {
                i++;
            }
        }
        return -1;
    }
    public void LPS(String s)
    {
        int i = 1 , j = 0;
        while(i < s.length())
        {
            if(s.charAt(i) == s.charAt(j))
            {
                j++;
                ar[i] = j;
                i++;
            }
            else if(j > 0)
            {
                j = ar[j-1];
            }
            else
            {
                ar[i] = 0;
                i++;
            }
        }
    }
}