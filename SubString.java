package com.ds.rani.string;

/**
 * Implement strStr().
 * <p>
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <p>
 * Example 1:
 * <p>
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 * <p>
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 */
//approach:start traversing haystack,if needles first character matches with haystack character then traverse
//both strings parralelly, if needle is covered then return the of haystack where needle was occured
//Time Complexity:o(n) where n is length of haystack
//Space Complexity:o(1)
public class SubString {
    public int strStr(String haystack, String needle) {
        if (needle == "") return 0;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j;
            for (j = 0; j < needle.length(); j++)
                if (haystack.charAt( i + j ) != needle.charAt( j ))
                    break;
            if (j == needle.length())
                return i;


        }
        return -1;

    }
}
