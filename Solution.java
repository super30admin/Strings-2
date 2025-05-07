// Time: O((n-m)*m), Space: O(1) — where n = haystack length, m = needle length

/*
    1. Iterate through `haystack` and attempt to match the `needle` from each position.
    2. Use a while loop to compare the characters.
    3. Return the starting index if the full `needle` is found, otherwise return -1.
*/
public class Solution 
{
    public int strStr(String haystack, String needle) 
    {

        if (needle.length() == 0) return 0;

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j = 0;
            while (j < needle.length() && i + j < haystack.length() && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            if (j == needle.length()) {
                return i;
            }
        }

        return -1;
    }
}
    
