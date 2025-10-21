# Time Complexity : O(N) where N is the length of the string
# Space Complexity : O(1) as we are using a fixed size array of size 26
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# I am using a sliding window approach to solve this problem.
# I am maintaining a window of size equal to the length of the pattern string p.
# I am using two hash maps to store the frequency of characters in the pattern string and the current window.
# I am sliding the window one character at a time and checking if the current window is an anagram of the pattern string.
# If it is, I add the starting index of the window to the result list.

from typing import List
from collections import Counter
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        pCounter = Counter(p)
        sCounter = Counter()
        result = []
        for i in range(len(s)):
            sCounter[s[i]] += 1
            if i >= len(p):
                if sCounter[s[i - len(p)]] == 1:
                    del sCounter[s[i-len(p)]]
                else:
                    sCounter[s[i-len(p)]] -= 1
            if pCounter == sCounter:
                result.append(i-len(p)+1)
        return result