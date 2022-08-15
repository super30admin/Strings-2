# Pointer solution
# Time Complexity = O(m + n), where m = len(p), n = len(s). Hashmap recorded for p, pointers traversed for s
# Space Complexity = O(1)


class Solution:
    def findAnagrams(self, s: str, p: str) -> list[int]:
        if len(s) == 0 or len(p) == 0 or len(p) > len(s):
            return []
        
        # Initialising the pointer
        fast = 0
        
        match = 0
        hashMap = {}
        result = []
        
        
        for i in range(len(p)):
            char = p[i]
            if char not in hashMap:
                hashMap[char] = 1
            else:
                hashMap[char] += 1
            
            
        
        for fast in range(len(s)):
            inChar = s[fast]        
            # For incoming char, if in map, count --, and if count == 0, match ++
            if inChar in hashMap:
                hashMap[inChar] -= 1
                if hashMap[inChar] == 0:
                    match += 1
                    
            if fast >= len(p):
                outChar = s[fast - len(p)]      # slow pointer at fast - len(p) + 1
                # For outgoing char, if in map, count ++, and if count == 1, match --
                if outChar in hashMap:
                    hashMap[outChar] += 1
                    if hashMap[outChar] == 1:
                        match -= 1
                        
            if match == len(hashMap):
                result.append(fast - len(p) + 1)        # returning a list of slow pointer indexes
        
        return result
                    