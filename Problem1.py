from collections import Counter


class Solution:
    # Time Complexity: O(nk)
    # Space Complexity: O(n)
    def findAnagrams(self, s: str, p: str) -> List[int]:
        pmap = Counter(p)
        result = []
        smap = Counter(s[: len(p)])
        for i in range(len(s) - len(p)):
            if pmap == smap:
                result.append(i)
            smap[s[i]] -= 1
            if smap[s[i]] == 0:
                del smap[s[i]]
            if s[i + len(p)] in smap:
                smap[s[i + len(p)]] += 1
            else:
                smap[s[i + len(p)]] = 1
        if pmap == smap:
            result.append(len(s) - len(p))
        return result
