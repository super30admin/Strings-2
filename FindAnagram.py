"""
Given two strings s and p, return an array of all the 
start indices of p's anagrams in s. You may return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters 
of a different word or phrase, typically using all the original letters exactly once.

"""

# Time Complexity : O(n)
# Space Complexity : O(m)
# Did this code successfully run on leetcode : Yes
# Any problem you faced while coding this : No

from typing import List

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:

        map1 = {}
        result = []
        
        
        # null
        if not s or len(s) == 0 or len(p) > len(s):
            return result

        for i in p :
            if i in map1:
                map1[i] +=1
            else:
                map1[i] = 1
                
        match = 0
                        
        for i in range(len(s)):
            in_ = s[i]

            if in_ in map1:
                count = map1[s[i]]
                count -=1
                if count ==0 :
                    match +=1
                map1[s[i]] = count

            if i >= len(p):       
                out = s[i - len(p)]
                
                if out in map1:
                    count = map1[out]

                    count +=1

                    if count == 1:
                        match -=1
                    map1[out] = count

            if match == len(map1):

                result.append(i - len(p) +1)

        return result