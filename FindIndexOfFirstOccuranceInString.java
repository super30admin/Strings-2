// Time Complexity : O(m + n) where m = len of heystack and n = len of needle
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach -
//   - Use Rabin-Karp rolling hash algorithm to efficiently compute hash of needle and substrings of haystack.
//   - Slide a window of length n over haystack and compare hash values.
//   - If hash matches, return index; otherwise continue sliding window.
//   - This avoids direct character comparison at every index.


public class FindIndexOfFirstOccuranceInString {
    // public int strStr(String haystack, String needle) {
    //     int m = haystack.length();
    //     int n = needle.length();

    //     int i = 0;
    //     while(i <= m - n) {
    //         int j = 0; //ptr on needle
    //         if(haystack.charAt(i) == needle.charAt(j)) {
    //             int k = i;
    //             while(haystack.charAt(k) == needle.charAt(j)) {
    //                 k++;
    //                 j++;
    //                 if(j == n) {
    //                     return i;
    //                 }
    //             }
    //         }
    //         i++;    //char not matched so incr i
    //     }

    //     return -1;
    // }

    //Robin-Karp
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        long pHash = 0;
        long prime = 100001;

        for(int i = 0; i < n; i++) {
            char c = needle.charAt(i);
            pHash = (pHash * 26 + (c - 'a' + 1)) % prime; //start from 1, 2 for a, b...
        }

        long currHash = 0;
        // long posFac = (long)Math.pow(26, n);
        long posFac = 1;
        for(int i = 0; i < n; i++) {
            posFac = (posFac * 26) % prime;
        }

        for(int i = 0; i < m; i++) {
            char in = haystack.charAt(i);
            currHash = (currHash * 26 + (in - 'a' + 1)) % prime;

            if(i >= n) {
                char out = haystack.charAt(i - n);
                currHash = (currHash - (posFac * (out - 'a' + 1))) % prime;
            }

            if(currHash < 0) {
                currHash += prime;
            }

            if(currHash == pHash) {
                return i - n + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        FindIndexOfFirstOccuranceInString obj = new FindIndexOfFirstOccuranceInString();

        String haystack1 = "hello";
        String needle1 = "ll";
        System.out.println("Index: " + obj.strStr(haystack1, needle1));  // Expected: 2

        String haystack2 = "aaaaa";
        String needle2 = "bba";
        System.out.println("Index: " + obj.strStr(haystack2, needle2));  // Expected: -1

    }
}
