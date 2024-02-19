
"""
28. Find the Index of the First Occurrence in a String
Easy
"""
from leetcode_runner import LeetCode, TestCase, Args
from typing import *

PROBLEM = """
Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 
Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.

Example 2:

Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.

 
Constraints:

1 <= haystack.length, needle.length <= 104
haystack and needle consist of only lowercase English characters.


"""

class Solution:
    """
    Accepted
    Time Complexity: O(m + n) # m is the length of the needle and n is the length of the haystack
    Space Complexity: O(1)
    
    Approach: Rabin-Karp Algorithm
    1. Calculate the hash for the needle and the first substring of haystack
    2. If the hashes match, return the index
    3. If not, slide the window and calculate the hash for the next substring
    4. If the hashes match, return the index
    5. If not, repeat step 3 and 4 until the end of the haystack
    6. If no match is found, return -1
    7. The hash is calculated using the formula:
        hash += dic(char) * base^power where power is the length of the substring - 1
    8. The hash is updated using the formula:
        hash = (hash - dic(char) * base^power) * base + dic(char)
    9. The base is 26 and the power is the length of the substring - 1
    
    #NOTE: It turns out that we never explicitly need to compute the hash value of every m-substring. We only need to compute the hash value of the first m-substring of haystack and needle. For the remaining m-substrings of haystack, we can:
    Rolling can be done like this
    - Multiply the hash value of the previous m-substring by base == 26.
    - Subtract the value of the first character of the previous m-substring, since we are moving the window by one character, 
        and that character is now out of the window.
    - Add the value of the last character of the current m-substring, since we are moving the window by one character.
    
    """
    def strStr(self, haystack: str, needle: str) -> int:
        if len(haystack) < len(needle): return -1
        dic = {
            'a': 1,
            'b': 2,
            'c': 3,
            'd': 4,
            'e': 5,
            'f': 6,
            'g': 7,
            'h': 8,
            'i': 9,
            'j': 10,
            'k': 11,
            'l': 12,
            'm': 13,
            'n': 14,
            'o': 15,
            'p': 16,
            'q': 17,
            'r': 18,
            's': 19,
            't': 20,
            'u': 21,
            'v': 22,
            'w': 23,
            'x': 24,
            'y': 25,
            'z': 26
        }
        pattern = 0
        curr_hash = 0
        base = 26
        power = len(needle) - 1
        for i in range(len(needle)): # O(m) time
            _ = haystack[i]
            __ = needle[i]
            curr_hash += dic[_] * pow(base, power) # calculate the hash for the first window substring
            pattern += dic[__] * pow(base, power) # calculate the hash for the needle
            power -= 1
        
        if pattern == curr_hash: return 0
        for i in range(len(haystack) - len(needle) ):
            _ = haystack[i]
            # ROLLING the HASH
            curr_hash *= base # multiply the hash by the base
            curr_hash -= dic[_] * pow(base, len(needle) - 1) # delete the first character from the hash
            curr_hash += dic[haystack[i + len(needle)]] # add the next character to the hash
            if pattern == curr_hash:
                return i + 1
        return -1

    
    """
    Accepted
    Time Complexity: O(n*m) # n is the length of haystack and m is the length of needle
    """
    def strStr(self, haystack: str, needle: str) -> int:
        n = len(needle)
        for i in range(len(haystack) - n + 1): # O(n) time
            if haystack[i:i+n] == needle: return i # substring and needle match both take O(m) time
        return -1

LeetCode(PROBLEM, Solution).check()
