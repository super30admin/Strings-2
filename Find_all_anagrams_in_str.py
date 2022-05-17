#Leetcode 438 Find all anagrams in a string https://leetcode.com/problems/find-all-anagrams-in-a-string/
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        # 1. if one string can be formed by rearranging letters in other string
        # 2. length of both strings after rearranging  should be same
        # 3. Frequency of each alphabet is important and must be same between both anagrams
        
        if len(p) > len(s):
            return []
        
        # one hash map for p count
        pCount = {}
        sCount = {}
        
        for i in range(len(p)):
            pCount[p[i]] = 1 + pCount.get(p[i], 0)
            sCount[s[i]] = 1 + sCount.get(s[i], 0)
            
        res = [0] if sCount == pCount else []
        
        l = 0
        # right pointer starts from len(p) and goes all the way upto end of len(s)
        # add the elements to sCount hash, before incrementing left pointer, remove th remove           # the left most ele
        
        for r in range(len(p), len(s)):
            sCount[s[r]] = 1 + sCount.get(s[r],0)
            sCount[s[l]] -= 1
            
            
            if sCount[s[l]] == 0:
                sCount.pop(s[l])
            l += 1
            if sCount == pCount:
                res.append(l)
        return res
        #TC: O(string S )  SC: O(K) where K is fixed at 26 for english letters or O(1)
            
            