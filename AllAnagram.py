#Time COmplexity : O(M + N) where M is number of elements in s and N is number of elements in p
#Space Complexity : o(1)
class Solution(object):
    def findAnagrams(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: List[int]
        """
        d = {}
        res = []
        match = 0
        for i in p:
            if i not in d:
                d[i] = 1
            else:
                d[i] +=1
        for i in range (len(s)):
            c = s[i]
            if c in d:
                d[c]-=1
                if d[c]==0:
                    match +=1
            if i >= len(p):
                if s[i - len(p)] in d:
                    d[s[i - len(p)]]+=1
                    if d[s[i - len(p)]] ==1:
                        match -=1
            if match == len(d):
                res.append(i - len(p)+1)
        return res
