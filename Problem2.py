## Problem2 

# Find All Anagrams in a String (https://leetcode.com/problems/find-all-anagrams-in-a-string/)

# Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

# Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

# The order of output does not matter.

# Example 1:

# Input:
# s: "cbaebabacd" p: "abc"

# Output:
# [0, 6]

# Explanation:
# The substring with start index = 0 is "cba", which is an anagram of "abc".
# The substring with start index = 6 is "bac", which is an anagram of "abc".
# Example 2:

# Input:
# s: "abab" p: "ab"

# Output:
# [0, 1, 2]

# Explanation:
# The substring with start index = 0 is "ab", which is an anagram of "ab".
# The substring with start index = 1 is "ba", which is an anagram of "ab".
# The substring with start index = 2 is "ab", which is an anagram of "ab".

from collections import Counter
from typing import List

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        """
        Time Complexity: O(N + M) 
        - Building the Counter for `p` takes O(M) time, where M is the length of `p`.
        - The for loop iterates through `s` exactly once taking O(N) time, where N is the length of `s`. 
        - All dictionary operations inside the loop are O(1).
        
        Space Complexity: O(K) or O(1)
        - The Counter dictionary takes O(K) space where K is the number of unique characters in `p`. 
        - Since the strings only consist of lowercase English letters, K is at most 26. Therefore, the auxiliary space complexity is O(1).
        """
        slen = len(s)
        plen = len(p)
        
        # Edge case: If s is shorter than p, it's impossible to find an anagram.
        if slen < plen:
            return []

        # Frequency map for the target string 'p'.
        count = Counter(p)
        res = []
        
        # `matchc` keeps track of how many unique characters in `p` currently have 
        # their exact required frequencies met inside our sliding window.
        matchc = 0

        # Slide a window across string 's'
        for i in range(slen):
            # INCOMING CHARACTER: The character entering the right side of the window
            c = s[i]
            if c in count:
                count[c] -= 1
                # If the frequency drops to 0, we've perfectly matched the needed occurrences for 'c'
                if count[c] == 0:
                    matchc += 1

            # OUTGOING CHARACTER: The character falling out of the left side of the window 
            # (Triggered only when the window exceeds length 'plen')
            if i >= plen:
                out = s[i - plen]
                if out in count:
                    count[out] += 1
                    # If the frequency goes from 0 to 1, we just lost our perfect match for 'out'
                    if count[out] == 1:
                        matchc -= 1

            # VALID ANAGRAM CHECK: If the number of fully matched unique characters equals 
            # the total unique characters in 'p', our window is a valid anagram.
            if matchc == len(count):
                # Add the starting index of the window: i - (window_length - 1)
                res.append(i - (plen - 1))

        return res