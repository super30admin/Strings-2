/* Problem Statement:

VERIFIED ON LEETCODE PLATFORM 
438. Find All Anagrams in a String
Medium

Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".


 * Solution 1: using a fixed 26 size array of alphabets ie hash map   
 * Time complexity: O(n) : where n is size of string S  
 * space complexity: O(1) as the hash map size is fixed (excludes the result array) 

 *
 */

class Solution {
public:
    /* constants for use in program */
    const int CHAR_LEN = 26;
    const int INVALID = -100;
    vector<int> findAnagrams(string s, string p) {
        int freq[CHAR_LEN];
        int idx, offset;

        int s_len = s.length();
        int p_len = p.length();
        int count = 0;
        int unique_char = 0;
        vector<int> result;
        
        /* init validations */
        if (!s_len || !p_len) {
            return result;
        }
        
        /* initialize array with fixed values to differentiate between valid char in pattern */
        for (idx = 0 ;idx < CHAR_LEN; idx++) {
            freq[idx] = INVALID;
        }
        /* only for the char in pattern, do this task. also count unique char in pattern */
        for (idx = 0; idx < p_len; idx++) {
            if (freq[p[idx]-'a'] == INVALID) {
                freq[p[idx]-'a'] = 0;  
                unique_char++;
            }
            freq[p[idx]-'a']++;
        }
        
        idx = 0;
        /* Approach:
        * 1. Iterate over each char in the array. If its a valid char from the pattern, decrement the count by 1.
        * Once the count reaches 0 for that particular char, increment the count which means I am done with the occurences
          expected for that char. eg : abba : if freq[a] becomes 0, it means we have encountered a 2 times for the pattern and
          now we are looking for rest of the char in b.
          By doing this, once we get the count same as unique_char, we know that we have matched the pattern.

          Once we match the pattern, the first char of the pattern in the sliding window needs to be added back as we have now used it
          and while adding back if we are adding it for the 1st time for that occurence decrement the count now. It means I have
          now removed this char from my count and would expect it again for matching if it is really present.
        *
        *
        *
        */
        while (idx < s_len) {
            /* Update count when the freq of char becomes 0, ie we have consumed it */
            offset = s[idx]-'a';
            if (freq[offset] != INVALID) {
                freq[offset]--;
                if (freq[offset] == 0)
                    count++;
            }
            /* start from the case where atleast we have reached the sliding window of the length */
            if (idx >= (p_len - 1)) {
                if (count == unique_char) {
                    result.push_back(idx - p_len + 1);
                }
                offset = s[idx - p_len + 1] - 'a';
                if (freq[offset] != INVALID){
                    freq[offset]++;
                    if (freq[offset] == 1)
                        count--;
                }
            }
            idx++;
        }
        return result;
        
    }
};
/* Execute on leetcode platform */


