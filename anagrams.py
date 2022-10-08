#Time: O(n)
#Space: O(m+n)
#Problem ran on leetcode successfully

class Solution(object):
    def findAnagrams(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: List[int]
        """
        if len(p) > len(s):
            return []
        pMap = {}
        sMap = {}
        for i in range(len(p)):
            pMap[p[i]] = pMap.get(p[i], 0) + 1
            sMap[s[i]] = sMap.get(s[i], 0) + 1
        
        if pMap == sMap: 
            result = [0]
        else:
            result = []
        
        left = 0
        for right in range(len(p), len(s)):
            sMap[s[right]] = sMap.get(s[right], 0) + 1
            sMap[s[left]] += -1
            
            if sMap[s[left]] == 0:
                sMap.pop(s[left])
            
            left += 1
            if sMap == pMap:
                result.append(left)
        
        return result
            