"""
TC: O(M+N) where M = length(p) and N = length(s)
SC: O(26) ~O(1) for the pMap

Logic:
Use a 2 pointer method.
1. Create a counter of all chars in p, call it pMap
2. Iterate through s and there are 2 scenarios
    2.1 New elements are added to the window. Here, decrement pMap and check if pMap value becomes 0. If yes, we have a match
    and increment match
    2.2 When the current window is greater than the expected window(size of p), remove elemnts from current window by moving left pointer.
    Before moving, reset the pMap and match. Once pMap is reset, check if value is 1. If yes, the elemnt was part of a previous match and we have
    to reset the match bydecrementing match
"""
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        l = 0
        r = 0
        pMap = Counter(p)
        window = len(p)
        result = []
        match = 0

        while(r<len(s)):
            rChar = s[r]
            if rChar in pMap:
                pMap[rChar]-=1
                if pMap[rChar]==0:
                    match+=1
            if r-l+1>window:
                lChar = s[l]
                if lChar in pMap:
                    pMap[lChar]+=1
                    if pMap[lChar]==1:
                        match-=1
                l+=1
            if match == len(pMap):
                result.append(l)
            r+=1
        return result