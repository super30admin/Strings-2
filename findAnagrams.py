# T: O(n), S: O(1)
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        countMap = {}
        for i in range(len(p)):

            if p[i] in countMap:
                countMap[p[i]] += 1

            else:
                countMap[p[i]] = 1

        match = 0
        result = []
        for i in range(len(s)):
            if s[i] in countMap:
                countMap[s[i]] -= 1

                if countMap[s[i]] == 0:
                    match += 1

            if i >= len(p):
                out = s[i - len(p)]  # 3-len(p)= 3-3=0 ie the index of c

                if out in countMap:
                    countMap[out] += 1

                    if countMap[out] == 1:
                        match -= 1

            if (match == len(countMap)):
                result.append((i - len(p) + 1))

        return result
