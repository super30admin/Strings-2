# Time Complexity : O(m+n)
# # Space Complexity:o(1)
# #  Did this code successfully run on Leetcode : Yes


class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if s is None or len(s) == 0 or p is None or len(p) == 0:
            return []

        hashMap = {}
        result = []
        match = 0
        for c in p:
            hashMap[c] = hashMap.get(c, 0) + 1

        for i in range(0, len(s)):
            inChar = s[i]

            if inChar in hashMap:
                count = hashMap[inChar]
                count -= 1
                hashMap[inChar] = count

                if count == 0:
                    match += 1

            if i >= len(p):
                if s[i - len(p)] in hashMap:
                    count = hashMap[s[i - len(p)]]
                    count += 1
                    hashMap[s[i - len(p)]] = count

                    if count == 1:
                        match -= 1

            if match == len(hashMap):
                result.append(i - len(p) + 1)

        return result
