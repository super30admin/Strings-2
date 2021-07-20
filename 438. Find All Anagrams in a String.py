"""
Time complexity:  O(m+n)
Space Complexity: O(1)
"""
from typing import List


class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        result=[]
        if s==None or len(s)==0 or len(s)<len(p):
            return result

        hashmap={}
        for i in range(len(p)): #put p in hashmap
            if p[i] in hashmap:
                hashmap[p[i]]+=1
            else:
                hashmap[p[i]]=1

        match=0
        for i in range(len(s)):
            incoming=s[i]

            if incoming in hashmap:
                count=hashmap[incoming]
                count-=1

                if count==0: #match found
                    match+=1
                hashmap[incoming]=count

            if i>=len(p):
                outgoing = s[i-len(p)]

                if outgoing in hashmap:
                    count = hashmap[outgoing]
                    count+=1

                    if count==1:
                        match-=1
                    hashmap[outgoing] = count

            if match==len(hashmap):
                result.append(i-len(p)+1)

        return result


s=Solution()
print(s.findAnagrams("cbaebabacd", "abc"))