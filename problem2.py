"""
We count the freq of chars in p and then store it in a map, then try and match the same window len of p to s and wherever we see a exact match of freq, we append left index to the
result list
TC is o(m + n) for processing p and s of len m and n resp, and space is o(1) for constant number of alphabets

"""

class Solution(object):
    def findAnagrams(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: List[int]
        """
        res = []
        left = 0
        pMap = [0] * 26
        windowMap = [0] * 26
        if len(s) < len(p):
            return []

        #for counting freq of elem in p
        for ch in p:
            pMap[ord(ch) - 97] += 1
        
        #for calc window freq
        for right in range(len(s)):
            windowMap[ord(s[right]) - 97] += 1
            
            #check if window and freq of p matches?
            if right - left + 1 > len(p):
                windowMap[ord(s[left]) - 97] -= 1
                left += 1

            #compare counts
            if windowMap == pMap:
                res.append(left)

        return res

        

        