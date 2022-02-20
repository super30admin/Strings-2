#Time and Space Complexity O(N)

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        c = dict()
        for ch in p:
            if ch in c: 
                c[ch] = c[ch]+1
            else:
                c[ch] = 1


        match = 0
        res = []
        for i in range(len(s)):
            inc = s[i]
            if inc in c:
                count = c[inc]
                count -= 1
                if count == 0:
                    match += 1
                c[inc] = count 
            if i >= len(p) :
                out = s[i-len(p)]
                if out in c:
                    cnt = c[out]
                    cnt += 1
                    if cnt == 1:
                        match = match - 1
                    c[out] = cnt

            if match == len(c):
                res.append(i - len(p) + 1)

        return res 
