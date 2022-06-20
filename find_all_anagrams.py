# Time Complexity : O(N) where N is length of the string
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        hashmap = {}
        zeros = 0
        start, end = 0, 0
        result = []
        for i in range(len(p)):
            if p[i] in hashmap:
                hashmap[p[i]] += 1
            else:
                hashmap[p[i]] = 1
                
        while end < len(s):
            if end >= len(p):
                if s[start] in hashmap:
                    hashmap[s[start]] += 1
                    if s[start] in hashmap and hashmap[s[start]] == 1:
                        zeros -= 1
                start += 1
                
            if s[end] in hashmap:
                    hashmap[s[end]] -= 1
                    if hashmap[s[end]] == 0:
                        zeros += 1

            if len(hashmap) == zeros:
                result.append(start)
                
            end += 1
                
        return result