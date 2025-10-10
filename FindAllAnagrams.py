#Time complexity: O(n)
#Space complexity: O(n) for using map

# The intuition here to store the freq of p string in a hash map and then using sliding window check for length of p in string s if we have an anagram using the freq in hashmap
# matches, if they do then store the start of the element.

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        pCount = Counter(p)
        matches = 0
        result = []
        for i in range(len(s)):
            if i >= len(p):
                # then only outgoing
                out = s[i - len(p)]
                if out in pCount:
                    cnt = pCount[out]
                    cnt += 1
                    if (cnt == 1):
                        matches -= 1
                    pCount[out] = cnt

            if s[i] in pCount:
                cnt = pCount[s[i]]
                cnt -= 1
                if (cnt == 0):
                    matches += 1
                pCount[s[i]] = cnt

            if len(pCount) == matches:
                result.append(i - len(p) + 1)
        return result