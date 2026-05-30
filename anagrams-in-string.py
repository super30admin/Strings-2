class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        result = []
        m = len(s)
        n = len(p)
        mp = {}
        # 1 - positive number means we still need 1 more of this character
        # 0 - we have the right amount for this character
        # -1 - we have too many of this character
        for c in p:
            mp[c]=mp.get(c,0)+1
        
        match = 0
        for i in range(len(s)):
            in_char = s[i]
            if in_char in mp:
                frq = mp[in_char]
                frq-=1
                mp[in_char]=frq
                if frq==0:
                    match+=1
                elif frq < 0:
                    match -= 1
            
            if i >= n:
                out_char = s[i-n]
                if out_char in mp:
                    frq = mp[out_char]
                    frq+=1
                    mp[out_char]=frq
                    if frq == 1:
                        match -= 1
                    elif frq <= 0:
                        match += 1
            if match == len(mp):
                result.append(i-n+1)
        
        return result

