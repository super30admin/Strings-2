package Strings2;

public class question97_Implementstrstr {
    /* Created by palak on 7/14/2021 */

    /*
        Time Complexity: O(m * n)
        Space Complexity: O(n)
    */
    public static int strStr(String haystack, String needle)
    {
        if(needle.length() == 0)
        {
            return 0;
        }

        int hLength = haystack.length();
        int nLength = needle.length();

        for(int i = 0 ; i < hLength - nLength + 1 ; i++)
        {
            if(haystack.substring(i, i + nLength).equals(needle))
            {
                return i;
            }
        }
        return -1;
    }


    /*
    Using KMP Algorithm
        Time Complexity: O(2m) => O(m)
        Space Complexity: O(1)
    */
    public static int strStr1(String haystack, String needle) {
        if(needle.length() == 0) return 0;

        int m = haystack.length();
        int n = needle.length();
        int i = 0;
        int j = 0;
        int[] lps = lps(needle);

        while(i < m) {
            if(haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if(j == n) return i - n;
            } else if(haystack.charAt(i) != needle.charAt(j) && j > 0) {
                j = lps[j - 1];
            } else if(haystack.charAt(i) != needle.charAt(j) && j == 0) i++;
        }
        return -1;
    }
    private static int[] lps(String needle) {
        int[] lps = new int[needle.length()];
        int i = 1;
        int j = 0;
        while(i < needle.length()) {
            // Case1
            if(needle.charAt(i) == needle.charAt(j)) {
                j++;
                lps[i] = j;
                i++;
            } else if(needle.charAt(i) != needle.charAt(j) && j > 0) { // case2
                j = lps[j - 1];
            }
            else if(needle.charAt(i) != needle.charAt(j) && j == 0) { // case3
                lps[i] = 0;
                i++;
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";

        System.out.println(strStr(haystack, needle));
        System.out.println(strStr1(haystack, needle));
    }
}