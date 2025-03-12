#time complexity o(m+n) = o(n)
#space complexity o(1)

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        pmap = defaultdict(int)
        pl = len(p)
        sl = len(s)
        result = []
        match = 0
        if pl > sl:
            return result
        for i in range(pl):
            pmap[p[i]] += 1
        
        for i in range(sl):
            #incoming character
            In = s[i]
            if In in pmap:
                cnt = pmap[In]
                cnt -= 1
                if cnt == 0:
                    match += 1
                pmap[In] = cnt
 
            if i >= pl:
                #outgoing character
                out = s[i-pl]
                if out in pmap:
                    cnt = pmap[out]
                    cnt += 1
                    if cnt == 1:
                        match -= 1
                    pmap[out] = cnt

            if match == len(pmap):
                result.append(i-pl+1)
        
        return result

                