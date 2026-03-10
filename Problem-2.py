# Time Complexity : O(n), n = length of s
# Space Complexity : O(1), fixed size count arrays for letters a-z
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# 1. Use sliding window of size len(p) over s.
# 2. Maintain frequency count of characters in window and compare with p.
# 3. Append starting indices where counts match to result.

from typing import List

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        from collections import Counter
        res = []
        len_p = len(p)
        count_p = Counter(p)
        count_s = Counter()
        
        for i, char in enumerate(s):
            count_s[char] += 1
            if i >= len_p:
                left_char = s[i - len_p]
                if count_s[left_char] == 1:
                    del count_s[left_char]
                else:
                    count_s[left_char] -= 1
            if count_s == count_p:
                res.append(i - len_p + 1)
        return res