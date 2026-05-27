# Time Complexity: O(m+n)
# Space Complexity: O(1) max 26 chars in the map
# Did this code successfully run on Leetcode: Yes

from collections import defaultdict

class Solution(object):
    def findAnagrams(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: List[int]
        """
        hmap=defaultdict(int)
        plen=len(p)
        slen=len(s)
        
        res=[]
        match=0

        if plen > slen: return res

        for c in p:
            hmap[c]+=1

        for i in range(slen):
            #in
            incoming=s[i] 
            if incoming in hmap:
                hmap[incoming]-=1
                if hmap[incoming]==0:
                    match+=1
            
            #out
            if i>=plen:
                outgoing=s[i-plen]
                if outgoing in hmap:
                    hmap[outgoing]+=1
                    if hmap[outgoing]==1:
                        match-=1
            

            if match==len(hmap):
                res.append(i-plen+1)

        return res


        