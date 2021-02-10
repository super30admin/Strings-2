public class Solution {
    public int strStr(String haystack, String needle) 
    {
        int i =0;
        int count = needle.length();

        while (count<= haystack.length())
        {
            String temp = haystack.substring(i, count);

            if (needle.equals(temp))
                return i;

            i++;
            count++;
        }
        return -1;
    }
}

//Time complexity : O(n*m) where n is the length of haystack and m is the length of needle
//Space complexity : O(1)
