# Time Complexity = O(m +n)
# Space Complexity = O(m +n)

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        hashMap = {}
        
        for c in p:
            hashMap[c] = 1 + hashMap.get(c,0)
        left = 0
        right = 0
        count = 0
        result = []

        while right < len(s):
            if s[right] in hashMap:
                hashMap[s[right]] -= 1
                if hashMap[s[right]] == 0:
                    count += 1
            if right - left +1 > len(p):
                if s[left] in hashMap:
                    if hashMap[s[left]] == 0:
                        count -= 1
                    hashMap[s[left]] += 1
                left += 1

            if count == len(hashMap):
                result.append(left)
            right += 1
        return result

