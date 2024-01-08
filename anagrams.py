"""
Time Complexity : O(m+n) where m is the length of p and n is the length of s. But at the end it will be o(n) as n > m
Space Complexity : O(1). Though we are using hashMap, hashMap will have at the most 26 entries in it.

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
1. Brute force approach has time complexity of O(n*m) where n is the length of s and m is the length of p
2. So we can utilize sliding window to improve the time complexity. Sliding window is chosen as we always have to check the characters of fixed window size m.
3. Create a frequencyMap for all the charactes in the p, (key: char, val: frequency of the char in p)
4. Iterate through the s, at every iteration we will have incoming character and outgoing character as window size is fixed
5. If incoming character is present in hashMap, decrease the frequency in hashMap by 1, if the frequency == 0, match += 1
6. If outgoing character is present in hashMap, increase the frequency in hashMap by 1, if the frequency == 1, match -= 1
7. If match == len(hashMap), include the first index of the given window to result
8. return result
"""
from collections import defaultdict


class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if len(s) == 0 or len(p) == 0:
            return []

        # create a hashMap
        hashMap = defaultdict(int)
        for char in p:
            hashMap[char] += 1

        result = []
        match = 0
        m = len(p)

        for i in range(len(s)):
            inChar = s[i]
            if inChar in hashMap:
                hashMap[inChar] -= 1
                if hashMap[inChar] == 0:
                    match += 1

            if i >= m:
                outChar = s[i-m]
                if outChar in hashMap:
                    hashMap[outChar] += 1
                    if hashMap[outChar] == 1:
                        match -= 1

            if match == len(hashMap):
                result.append(i-m+1)

        return result
