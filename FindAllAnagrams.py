#-----------------sliding window------------------
#Space = O(p) + O(s), Space = O(1)-----------------------
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if len(s) < len(p) or len(s) == 0 or len(p) == 0:
            return []
        match = 0
        result = []
        hashMap = {}
        for char in p:
            if char in hashMap:
                hashMap[char] += 1
            else:
                hashMap[char] = 1
        
        for i, char in enumerate(s):
            # incoming character
            if char in hashMap:
                count = hashMap[char]
                count -= 1
                if count == 0:
                    match += 1
                hashMap[char] = count

            # outgoing character
            if i >= len(p):
                out = s[i - len(p)]
                if out in hashMap:
                    count = hashMap[out]
                    count += 1
                    if count == 1:
                        match -= 1
                    hashMap[out] = count

            # record the index if match == len(hashMap)
            if match == len(hashMap):
                result.append(i - len(p) + 1)
        return result
        