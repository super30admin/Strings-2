#Time Complexity :O(m+n)
#Space Complexity :O(1) 26 char
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        m=len(s)
        n=len(p)
        map={}
        result=[]
        match=0
        for i in range(n):
            if p[i] not in map.keys():
                map[p[i]]=0
            map[p[i]]+=1
        
        for i in range(m):
            c=s[i]
            #in
            if c in map.keys():
                map[c]-=1
                if map[c]==0:
                    match+=1

            #out
            if i>=n:
                out=s[i-n]
                if out in map.keys():
                    map[out]+=1
                    if map[out]==1:
                        match-=1

            if match==len(map):
                result.append(i-n+1)

        return result

