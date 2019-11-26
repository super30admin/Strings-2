/* Problem Statement:

VERIFIED ON LEETCODE PLATFORM 
28. Implement strStr()
Easy

Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2

Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1

Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().


 * Solution 1: using Knuth Morris Pratt matching   
 * Time complexity: O(n+m) :  n is size of haystack, m is size of needle 
 * space complexity: O(m) 

 *
 */

class Solution {
public:
    int strStr(string haystack, string needle) {
        int idx = 0, idx2 = 0;
        int fin_idx = -1;
        int hs_len = haystack.length();
        int needle_len = needle.length();
        
        /* If needle len is 0, return 0 as per instructions */
        if (!needle_len) {
            return 0;
        }
        
        /* validations */
        if (!hs_len) {
            return fin_idx;
        }

        /* Need to preapre prefix suffix array for KMP match */
        int *needle_arr = new int[needle_len];
        
        /* Build pattern array for needle : KMP string matching */
        needle_arr[idx2] = 0;
        idx2 = 1;
        /* Start from 1st and 2nd elem . ie idx with 0 and idx2 with 1
        * Keep moving idx2 until we find a matching characters 
        */
            
        while ((idx2 < needle_len) && (needle[idx] != needle[idx2])) {
            needle_arr[idx2] = 0;
            idx2++;
        }
        /* Now, if we dont find matching characters, then move your idx to needle_arr[idx - 1]
        * Once its done, check again if the char dont match, then add 0 to that idx2 index.
        * If it matches then store idx+1 at idx2 position.
        * increment idx2
        */
        while(idx2 < needle_len) {
            if (needle[idx] != needle[idx2]) {
                if (idx != 0) {
                    idx = needle_arr[idx - 1];
                }
            } 
            if (needle[idx] != needle[idx2]) {
                needle_arr[idx2] = 0;
            }
            else {
                needle_arr[idx2] = idx + 1;
                idx++;
            }
            idx2++;
        }
        
        /* Prepared array successfully, lets use it to match it in haystack */
        idx = 0, idx2 = 0;
        while (idx < hs_len) {
            /* match char, move both pointers */
            if (haystack[idx] == needle[idx2]) {
                idx2++;
                idx++;
            } else {
                /* doesnt match, so if we are in between the pattern, move pattern idx2 to the position at value of idx2 - 1*/
                if (idx2 != 0) {
                    idx2 = needle_arr[idx2 - 1];
                } else {
                    /* we are at first char of pattern, so move your haystack pointer now */
                    idx++;
                }
            }
            /* pattern search finished, break the loop and count the start of the pattern */
            if (idx2 == needle_len) {
                fin_idx = idx - needle_len;
                break;
            }
        }
        delete[] needle_arr;
        return fin_idx;
    }
};
/* Execute on leetcode platform */


