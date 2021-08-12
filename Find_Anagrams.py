#Time:O(n)
#Space:O(26)
from collections import Counter
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if not s:
            return 0
        match = 0
        counter = Counter(p)
        ans = []
        for i in range(len(s)):
            if s[i] not in counter:
                pass
            else:
                counter[s[i]]-=1
                if counter[s[i]]==0:
                    match+=1
                    if match == len(counter):
                        ans.append(i-len(p)+1)
            
            if i>=len(p)-1 and s[i-len(p)+1] in counter:
                counter[s[i-len(p)+1]]+=1
                if counter[s[i-len(p)+1]]==1:
                    match-=1
        return ans