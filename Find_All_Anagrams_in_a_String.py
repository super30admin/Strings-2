# Time Complexity : O(n + m), where n is the length of s and m is the length of p
# Space Complexity : O(m), where m is the length of p
from collections import Counter
from typing import List

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        p_count = Counter(p)
        window_count = Counter(s[:len(p)])
        result = []
        
        if p_count == window_count:
            result.append(0)
        
        for i in range(1, len(s) - len(p) + 1):
            if s[i - 1] in window_count:
                window_count[s[i - 1]] -= 1
                if window_count[s[i - 1]] == 0:
                    del window_count[s[i - 1]]
            
            if s[i + len(p) - 1] in window_count:
                window_count[s[i + len(p) - 1]] += 1
            else:
                window_count[s[i + len(p) - 1]] = 1
            
            if p_count == window_count:
                result.append(i)
        
        return result