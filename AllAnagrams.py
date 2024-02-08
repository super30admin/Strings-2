# Problem2 Find All Anagrams in a String (https://leetcode.com/problems/find-all-anagrams-in-a-string/)

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        result = []
        hashMap = dict()
        n = len(p)
        for i in p:
            if i in hashMap.keys():
                hashMap[i] += 1
            else:
                hashMap[i] = 1
        match = 0
        for i in range(len(s)):
            incoming = s[i]
            if incoming in hashMap.keys():
                hashMap[incoming] -= 1
                if hashMap[incoming] == 0:
                    match += 1
            if i >= n:
                outgoing = s[i - n]
                if outgoing in hashMap.keys():
                    hashMap[outgoing] += 1
                    if hashMap[outgoing] == 1:
                        match -= 1
            if match == len(hashMap):
                result.append(i - n + 1)
        return result
# Time complexity O(len(s))
# Space complexity O(1)