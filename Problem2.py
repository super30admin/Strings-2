# 438. Find All Anagrams in a String
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        n = len(s)
        result = []
        for i in range(n):
            k = i
            j = 0
            while s[k] == p[j]:
                k += 1
                j += 1
                if j == len(p)-1:
                    print(k,j)
                    result.append(k-len(p))
                    break
        return result
