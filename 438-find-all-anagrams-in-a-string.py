
"""
438. Find All Anagrams in a String
Medium
"""
import collections
from leetcode_runner import LeetCode, TestCase, Args
from typing import *

PROBLEM = """
Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 
Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

 
Constraints:

1 <= s.length, p.length <= 3 * 104
s and p consist of lowercase English letters.


"""

class Solution:
    """
    Accepted
    Time Complexity: O(n)
    Space Complexity: O(1) 
    Approach: Sliding Window
        - hash the pattern into a freq map
        - Maintain a window of length of pattern and hash the window into a seperate freq map
        - If the freq map of the window matches the freq map of the pattern, then the window is an anagram
        - Move the window by 1 and update the freq map of the window and kep checking if the window is an anagram
        - save the index of the window if it is an anagram
    """
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if len(s)< len(p): return []
        pattern = {}
        lis = []
        for c in p:
            pattern[c] = pattern.get(c, 0) + 1 # pattern freq map
        freq = collections.defaultdict(int)
        for i in range(len(p)):
            freq[s[i]] +=1 # initial window freq map
        i, j =0, len(p) - 1

        while j < len(s)-1:
            if freq == pattern: # anaagram check
                lis.append(i)
            freq[s[i]] -= 1
            if freq[s[i]] == 0: del freq[s[i]] # remove the left most character from the window
            i += 1 # slide
            j += 1 # slide
            freq[s[j]] += 1 # add the right most character to the window
        if freq == pattern:
                lis.append(i)
        return lis

LeetCode(PROBLEM, Solution).check()
