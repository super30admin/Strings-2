from ast import List
from collections import Counter


class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        dict_p = Counter(p)
        res = []
        for idx, ch in enumerate(s):
            if ch in dict_p:
                found = 0
                foundVals = Counter(p)
                i = len(p) + idx
                if i <= len(s):
                    for j in range(idx,i):
                        if s[j] in dict_p:
                            foundVals[s[j]] -= 1
                            if foundVals[s[j]] == 0:
                                found += 1
                        else:
                            break

                    if found == len(dict_p):
                        res.append(idx)
                else:
                    break

        return res



