'''
creating a frequency hash and comparing it to p's frequency hash
if they match then we have anagram

since we use sliding window

TC: O(n)
SC: O(26*2)

'''


class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        pHash = [0 for i in range(26)]
        currHash = [0 for i in range(26)]
        
        for ch in p:
            pHash[ord('a')- ord(ch)] += 1
        
        i = 0
        k = len(p)
        result = []
        for j in range(len(s)):
            
            currHash[ord('a')-ord(s[j])] += 1
            
            if j-i == k-1:
                if currHash == pHash:
                    result.append(i)
                
                currHash[ord('a')-ord(s[i])] -= 1
                i += 1
        return result
                    