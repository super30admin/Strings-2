class Solution(object):
    def findAnagrams(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: List[int]
        """
        p = sorted(p)
        start = 0
        l = []
        end = len(p)-1
        while end<len(s):
            if sorted(s[start:end+1])==p:
                l.append(start)
            start+=1
            end+=1
        return l