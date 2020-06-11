"""
    // Time Complexity :T = O(M) + O(N)
    // Space Complexity :O(n)
    // Did this code successfully run on Leetcode : YES
    // Any problem you faced while coding this : NA
    add all the pattern characters in hashmap with default value 1
    in character -> reduce its count in hashmap; if the cout is 0, increase match
    out character -> increase its count by 1 in hashmap; if count in hashmap == 1,decrease match
    if match == len(hashmap) it means anagram is found, add index
"""
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        hashMap = {}
        result = []
        match = 0

        for i in range(len(p)):
            hashMap[p[i]] =hashMap.get(p[i],0)+ 1

        for i in range(len(s)):
            """
                in character
            """
            inchar = s[i]
            if inchar in hashMap:
                cnt = hashMap.get(inchar) - 1
                if cnt == 0: match += 1
                hashMap[inchar] =  cnt
            """
                out char
            """
            if i > len(p)-1:
                outchar = s[i - len(p)]
                if outchar in hashMap:
                    cnt = hashMap.get(outchar) + 1
                    if cnt == 1: match -= 1
                    hashMap[outchar] = cnt

            if match == len(hashMap):
                index = i - len(p) + 1
                result.append(index)
        return (result)
