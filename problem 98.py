# https://leetcode.com/problems/find-all-anagrams-in-a-string/

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        len_p = len(p)
        p = sorted(p)
        res = []

        for i in range(len(s) - len_p + 1):
            if sorted(s[i:i+len_p]) == p:
                res.append(i)
        return res

# TC: O(mlogn) sorted p is n log n and for loop runs for m-n+1 and we are sorting 
# S string of length n everythime so n logn so (m-n+1 * nlogn) = mlogn

# SC: O(m+n) because we are using sorted


########################### 

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        sl = len(s)
        pl = len(p)

        hm = {}
        for i in range(pl):
            if p[i] not in hm:
                hm[p[i]] = 1
            else:
                hm[p[i]] += 1
        ans = []
        
        match = 0
        for i in range(sl):
            in_P = s[i]
            if in_P in hm:
                cnt = hm[in_P]
                cnt -= 1
                if cnt == 0:
                    match += 1
                hm[in_P] = cnt
            
            #out 
            if (i >= pl):
                out = s[i-pl]
                if out in hm:
                    cnt = hm[out]
                    cnt += 1
                    if cnt == 1:
                        match -= 1
                    hm[out] = cnt
            
            if match == len(hm):
                ans.append(i-pl+1)
        return ans

# TC: O(m+n)
# SC: O(m)