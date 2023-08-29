# Time Complexity :O(N)
# Space Complexity :O(P)
# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this :

# Your code here along with comments explaining your approach


class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        result=[]
        h={}
        n=len(s)
        len_p=len(p)
        slow=0
        match=0
        for i in p:
            h[i]=h.get(i,0)+1
        m=len(h)
        for i in range(n):
            in_char=s[i]
            if(h.get(in_char,"-1")!="-1"):
                h[in_char]-=1
                if(h[in_char]==0):
                    match+=1
            if(i-slow==len_p):
                out_char=s[slow]
                if(h.get(out_char, "-1")!="-1"):
                    h[out_char]+=1
                    if(h[out_char]==1):
                        match-=1
                slow+=1
            if(match==m):
                result.append(i-len_p+1)
        return result