# Time complexity - O(s)
# Space complexity - O(26) -> O(1)

# Approach - Create frequency map of chars in pattern. Maintain a variable (match) 
# which is increeemented whenever count is 0 with incoming char and is decreemented
# whenever count is 1 with outgoing char. When match == len(hashmap), append the 
# substring to our result.

from typing import List
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if len(p) > len(s):
            return []
        
        hashmap = dict()
        for i in range(len(p)):
            c = p[i]
            if c not in hashmap:
                hashmap[c] = 1
            else:
                hashmap[c] += 1
        
        Match = 0
        result = []
        for i in range(len(s)):
            # incoming
            inc = s[i]
            if inc in hashmap:
                count = hashmap[inc]
                count -= 1
                if count == 0:
                    Match += 1
                hashmap[inc] = count
                
            # outgoing
            if i >= len(p):
                out = s[i - len(p)]
                if out in hashmap:
                    count = hashmap[out]
                    count += 1
                    if count == 1:
                        Match -= 1
                    hashmap[out] = count
                
            if Match == len(hashmap):
                # record start idx
                result.append(i - len(p) + 1)
        return result