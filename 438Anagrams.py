from collections import Counter
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        
        p_hash = Counter(p)
        p_len = len(p)
        s_len = len(s)
        out = []
        for i in range(s_len-p_len+1):
            s_hash = Counter(s[i:i+p_len])
            if s_hash == p_hash:
                out.append(i)
                
        return out