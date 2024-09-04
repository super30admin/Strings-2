# Strings-2


## Problem 1 Implement strStr() (https://leetcode.com/problems/implement-strstr/)

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        haystack_length, needle_length = len(haystack), len(needle)

        # Check all possible starting positions of needle in haystack
        for start in range(haystack_length - needle_length + 1):
            # If the substring matching the needle's length equals the needle, return the start index
            if haystack[start : start + needle_length] == needle:
                return start
      
        # If the needle is not found in haystack, return -1
        return -1
# TC = O((n - m + 1) * m), SC =O(1) 

## Problem 2 Find All Anagrams in a String (https://leetcode.com/problems/find-all-anagrams-in-a-string/)

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if len(p) > len(s):
            return []
        hashMap = dict()
        match = 0
        result = []
        for i in range(len(p)):
            c = p[i]
            if c not in hashMap:
                hashMap[c] = 1
            else:
                hashMap[c] = hashMap[c]+1
        for i in range (len(s)):
            incoming = s[i]
            if incoming in hashMap:
                count = hashMap[incoming]
                count = count -1
                if count ==0:
                    match = match +1
                hashMap[incoming] = count
            if i >= len(p):
                outgoing = s[i-len(p)]
                if outgoing in hashMap:
                    count = hashMap[outgoing]
                    count  = count + 1
                    if count == 1:
                        match = match-1
                    hashMap[outgoing] = count 
            if match == len(hashMap):
                result.append(i-len(p)+1)
        return result   

#TC = O(m+n) where m = len(s), n = len(p); SC: O(1)        
        