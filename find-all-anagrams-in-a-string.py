"""
Runtime Complexity:
O(m+n) - we store the elements of list 'p' with count in a hashmap. We traverse over the element by having a window of size of p. If the size crosses then we out happens and we check if the out element
is present in hashmap and if yes then we increment the count and if the count equals to 1 then we decrement the match. We do the vice versa for the incoming elements.
Therefore we traverse m + n elements.
Space Complexity:
O(1) - because the hashmap contains only lower or uppercase alphabets which might sum upto 52 in total.
Yes, the code worked on leetcode.
Issues while coding- No 
"""


class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if len(s)==0 or len(p)>len(s):
            return []
        hm = Counter(p)
        result = []
        match = 0
        for i in range(len(s)):
            if s[i] in hm:
                hm[s[i]]-=1
                if hm[s[i]]==0:
                    match+=1
            if i >=len(p):
                if s[i-len(p)] in hm:
                    hm[s[i-len(p)]]+=1
                    if hm[s[i-len(p)]]==1:
                        match-=1
            if match == len(hm):
                result.append(i-len(p)+1)
                
        return result
        
        