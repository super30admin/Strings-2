# Time complexity - o(m+n)
# Space complexity - o(1)

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
       
        
        n = len(s)
        m = len(p)

        if m>n:
            return []

        countS = {}
        countP = {}

        for i in range(m):
            countS[s[i]] = 1 + countS.get(s[i],0)
            countP[p[i]] = 1 + countP.get(p[i],0)

        res = [0] if countS == countP else []
        l = 0

        for i in range(m,n):
            countS[s[i]] = 1 + countS.get(s[i],0)
            countS[s[l]] -= 1

            if countS[s[l]] == 0:
                del countS[s[l]]
            l+=1
            if countS == countP:
                res.append(l) 

        return res
            