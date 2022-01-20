class Solution:
    def findAnagrams(self, s: str, p: str):
        # Time Complexity - O(m+n)
        # Space Complexity  - O(1)
        if len(p) > len(s):
            return []
        pCount, sCount = {}, {}
        for i in range(len(p)):
            pCount[p[i]] = 1 + pCount.get(p[i], 0)
            sCount[s[i]] = 1 + sCount.get(s[i], 0)

        res = [0] if sCount == pCount else []

        l = 0
        for r in range(len(p), len(s)):
            sCount[s[r]] = 1 + sCount.get(s[r], 0)
            # Remove left char
            sCount[s[l]] -= 1

            # Remove the element from map because the equality operator doesn't hold true if the element is still in map even with count 0
            if sCount[s[l]] == 0:
                sCount.pop(s[l])

            l += 1

            if sCount == pCount:
                res.append(l)

        return res