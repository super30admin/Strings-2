# Time Complexity : O(n)
# Space Complexity : O(1) as there are not more than 26 characters
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : yes

import collections
from typing import List


class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:

        # take counter of first n elements in s_dict with n = len(p) - 1
        s_dict = collections.Counter(s[:len(p)-1])

        # counter of p
        p_dict = collections.Counter(p)

        start = 0

        # final result
        res = []

        # iterate over the string s, and in each step we check if s_dict and p_dict match
        for i in range(len(p)-1, len(s)):

            # updating the counter & adding the character
            s_dict[s[i]] = s_dict[s[i]] + 1

            # checking if counters match
            if s_dict == p_dict:
                res.append(start)

            # remove the first element from counter
            s_dict[s[start]] = s_dict[s[start]] - 1

            # if element count = 0, pop it from the counter
            if s_dict[s[start]] == 0:
                del s_dict[s[start]]

            start = start + 1

        return res
