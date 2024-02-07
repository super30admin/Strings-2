/*
* Approach:
*  1. Rolling Hash Algorithm along with sliding window:
        calculate the hash of needle:
            abcd 
            a->1, b->2, c->3, d->4 alphabets : 26, len = 4

            1*pow(26,4-1) + 2*pow(26,4-2) + 3*pow(26,4-3) + 4*pow(26,4-4)

            This hash will be unique for anagrams of same string.
* 
*  2. we slide the window and calculate the hash of elements inside window.
        once we reach the size of needle, we remove the elements from start,
            so that no of elements in window == elements in needle.
* 
*  3. If hash matches, return the start index of window.
        as we are dealing with power of 26, its preferred to use BigInteger.
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(n+m)
    n - length of needle
    m - length of haystack
* 
* Space Complexity: O(1)
* 
*/

import java.math.BigInteger;

public class FirstOccurence {
    // public int strStr(String haystack, String needle) {
    // int m = haystack.length();
    // int n = needle.length();

    // if (n > m)
    // return -1;

    // for (int index = 0; index < n; index++) {
    // if (haystack.charAt(index) == needle.charAt(0)
    // && haystack.substring(index, needle.length()).equals(needle)) {
    // return index;
    // }
    // }

    // return -1;
    // }

    public int strStr(String haystack, String needle) {
        int m = haystack.length();

        int n = needle.length();

        if (m < n)
            return -1;

        BigInteger hash = BigInteger.ZERO;

        BigInteger k = BigInteger.valueOf(26);

        for (int index = 0; index < n; index++) {
            char ch = needle.charAt(index);

            hash = hash.multiply(k).add(BigInteger.valueOf(ch - 'a' + 1));
        }

        BigInteger currhash = BigInteger.ZERO;

        for (int index = 0; index < m; index++) {
            if (index >= n) {
                currhash = currhash.mod(k.pow(n - 1));
            }

            char ch = haystack.charAt(index);

            currhash = currhash.multiply(k).add(BigInteger.valueOf(ch - 'a' + 1));

            if (currhash.compareTo(hash) == 0) {
                return index - n + 1;
            }
        }

        return -1;
    }
}