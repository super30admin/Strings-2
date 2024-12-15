class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        freq = Counter(p)
        n = len(p)
        res = []
        match = 0
        i = 0
        while i < len(s):
            inc = s[i]
            if inc in freq:
                freq[inc] -= 1
                if freq[inc] == 0:
                    match += 1
            if i-n >= 0:
                out = s[i-n]
                if out in freq:
                    freq[out] += 1
                
                if freq[out] == 1:
                    match -= 1

            if match == len(freq):
                res.append(i-n+1)
            
            i += 1
            
        return res

            
