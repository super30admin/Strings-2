'''
## Problem 438: Find all anagrams in a string.

## Author: Neha Doiphode
## Date:   08-16-2022

## Description:
    Given two strings s and p, return an array of all the start indices of p's anagrams in s.
    You may return the answer in any order.

    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
    typically using all the original letters exactly once.

## Examples:
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

## Constraints:
    1 <= s.length, p.length <= 3 * 104
    s and p consist of lowercase English letters.


## Time complexity : O(m + n) where m is length of pattern and n is the length of input string.

## Space complexity: O(1), as hashmap for the pattern at the max can have 26 lowercase characters only.

'''
from typing import List, Optional
from collections import Counter

def get_input():
    print("Enter the input string: ", end = "")
    string = input()
    print("Enter the anagram pattern string: ", end = "")
    pattern = input()
    print()
    return string, pattern

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if len(s) == 0 or len(p) > len(s):
            return []

        p_map = Counter(p)
        p_length = len(p)

        result = []

        match = 0
        cnt = 0

        for i in range(len(s)):
            # incoming character
            incoming_char = s[i]
            # If incoming character is present in the map
            # Decrement its count
            if incoming_char in p_map:
                p_map[incoming_char] -= 1

                # If the count becomes zero that means
                # we have found exact match for a character in p
                # so increment match
                if p_map[incoming_char] == 0:
                    match += 1

            # now check if there is an outgoing character
            if i >= p_length:
                outgoing_character = s[i - p_length]
                if outgoing_character in p_map:
                    # we now need to increment the count
                    # as our map keeps track of "requirement" of characters.
                    # if any character goes out of sliding window
                    # we need to increment the count in the map as,
                    # the character is now "required".
                    p_map[outgoing_character] += 1

                    # Now we need to check if the count of character has become 1
                    # If yes, we require the character
                    # And hence, match variable decreases by 1 as we have 1 less match
                    if p_map[outgoing_character] == 1:
                        match -= 1

            # If match becomes equal to the size of map,
            # it means that we have found an anagram
            # so we need to record the start index of anagram
            if len(p_map) == match:
                result.append(i - p_length + 1)
        return result


# Driver code
solution = Solution()
string, pattern = get_input()
print(f"Input string: {string}")
print(f"Input pattern for which we need to find starting indices of anagrams: {pattern}")
print(f"Starting indices of anagrams for the pattern {pattern} are: {solution.findAnagrams(string, pattern)}")
