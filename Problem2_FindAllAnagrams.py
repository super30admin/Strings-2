# Time Complexity: O(m + n), where m - length of s and n - length of p
# Space Complexity: O(1), due to constant char set

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if not s or len(s) == 0:
            return []

        result = []
        hmap = dict()
        match = 0

        for ch in p:
            if ch not in hmap:
                hmap[ch] = 0
            hmap[ch] += 1

        for i in range(len(s)):
            inchar = s[i]
            if inchar in hmap:
                hmap[inchar] -= 1
                if hmap[inchar] == 0:
                    match += 1

            if i >= len(p):
                outchar = s[i - len(p)]
                if outchar in hmap:
                    hmap[outchar] += 1
                    if hmap[outchar] == 1:
                        match -= 1

            if match == len(hmap):
                result.append(i - len(p) + 1)

        return result

