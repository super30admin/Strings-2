"""
TC: O(Ls + Lp) The time complexity is linear with respect to the length of string s (Ls) and string p (Lp). We perform an initial O(Lp) pass to build the Counter and then a single O(Ls) pass for the sliding window, with hash map operations taking average O(1) time.
SC: O(1) The space complexity is constant, O(1), because the hash map (Counter) holds at most 26 entries (for lowercase English letters), independent of the size of the input strings.

Approach:

This problem is solved using the Sliding Window technique with a Frequency Counter to find all start indices of anagrams of {p} within {s}.

1.  Initialization: We use a Counter to store the required frequencies of characters in {p}. The variable {ideal} stores the count of *unique* characters in {p}, and {match_count} tracks how many unique characters currently have a zero count in the sliding window.
2.  Sliding Window: We use a window of fixed size {len}(p) and slide it across s using the loop index i as the right boundary.
    * Roll In (Character s[i]): As a new character enters the window, we update its count in the {counter}. The {match_count} is adjusted: it increments if the count becomes 0 (a perfect match for that character) and decrements if it drops to -1 (we have an excess of that character in the window).
    * Roll Out (Character s[i - len(p)]): Once the window size is reached, we roll out the character leaving the window on the left. We increment its count in the {counter}. The {match_count} is again adjusted: it decrements if the count becomes 1 (no longer a perfect match) and increments if it becomes 0.
3.  Anagram Check: After each roll-in and roll-out (when the window is correctly sized), we check if {match_count} equals {ideal}. If they match, it means the current window contains a perfect frequency match for all unique characters in {p}, signifying an anagram. The starting index of this window ({i - len}(p) + 1) is recorded.

The problem ran successfully on LeetCode.
"""

from collections import Counter
from typing import List
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        match_count = 0
        counter = Counter(p)
        ideal = len(counter)
        res = []

        for i in range(len(s)):
            inn = s[i]
            if inn in counter:
                counter[inn] -= 1

                if counter[inn] == 0:
                    match_count += 1
                elif counter[inn] == -1:
                    match_count -= 1

            if i >= len(p):
                out = s[i - len(p)]
                if out in counter:
                    counter[out] += 1
                    if counter[out] == 1:
                        match_count -= 1
                    elif counter[out] == 0:
                        match_count += 1
        
            if match_count == ideal:
                res.append(i - len(p) + 1)

        return res