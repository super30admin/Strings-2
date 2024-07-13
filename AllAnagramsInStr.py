# Time Complexity : O(n), where n is the length of S
# Space Complexity : O(1)

from typing import List
from collections import defaultdict

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        result = []
        if not s or not p or len(s) < len(p):
            return result
        
        p_map = defaultdict(int)
        for ch in p:
            p_map[ch] += 1
        
        match = 0
        for i in range(len(s)):
            ch = s[i]
            if ch in p_map:
                p_map[ch] -= 1
                if p_map[ch] == 0:
                    match += 1
            
            if i >= len(p):
                outgoing_ch = s[i - len(p)]
                if outgoing_ch in p_map:
                    if p_map[outgoing_ch] == 0:
                        match -= 1
                    p_map[outgoing_ch] += 1
            
            if match == len(p_map):
                result.append(i - len(p) + 1)
        
        return result

# Examples
solution = Solution()

# Example 1
s1 = "cbaebabacd"
p1 = "abc"
print(solution.findAnagrams(s1, p1))  # Output: [0, 6]

# Example 2
s2 = "abab"
p2 = "ab"
print(solution.findAnagrams(s2, p2))  # Output: [0, 1, 2]

# Example 3
s3 = "af"
p3 = "be"
print(solution.findAnagrams(s3, p3))  # Output: []