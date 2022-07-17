# Time Complexity: O(n), n is length of s
# Space Complexity: O(1)
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        result=[]
        if len(p)>len(s): return result
        freq={}
        for c in p:
            if c not in freq:
                freq[c]=0
            freq[c]+=1
        slow=0
        match=0

        for i in range(len(s)):
            
            if s[i] in freq:
                freq[s[i]]-=1
                if freq[s[i]]==0:
                    match+=1
            if i>=len(p):
                out=s[slow]
                if out in freq:
                    freq[out]+=1
                    if freq[out]==1:
                        match-=1
                slow+=1
            if match==len(freq):
                result.append(slow)
        return result
        