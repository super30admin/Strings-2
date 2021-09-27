class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        """
        TC - O(|s|+|p|) = O(m+n)
        SC - O(1)
        """
        if not s or not p:
            return []
        result = []
        hp = dict()
        match = 0
        for i in list(p):
            if i in hp:
                hp[i] += 1
            else:
                hp[i] = 1
        for i in range(len(s)):
            if s[i] in hp:
                cnt = hp[s[i]]
                cnt -= 1
                if cnt == 0:
                    match += 1
                hp[s[i]] = cnt
            if i >= len(p):
                out = s[i-len(p)]
                if out in hp:
                    cnt = hp[out]
                    cnt += 1
                    if cnt == 1:
                        match -= 1
                    hp[out] = cnt
            if match == len(hp):
                result.append(i-len(p)+1)
        return result
            