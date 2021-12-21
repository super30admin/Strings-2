class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if len(s) == 0 or s == None:
            return []
        result = []
        hashmap = {}
        for char in p:
            hashmap[char] = hashmap.get(char, 0) + 1
            
        i, match = 0, 0
        
        while i < len(s):
            if s[i] in hashmap.keys():
                hashmap[s[i]] -= 1
                if hashmap[s[i]] == 0:
                    match += 1
            if i >= len(p):
                if s[i-len(p)] in hashmap.keys():
                    hashmap[s[i-len(p)]] += 1
                    if hashmap[s[i-len(p)]] == 1:
                        match -= 1       
            if match == len(hashmap):
                result.append(i-len(p) + 1)
            i += 1
        return result

# Time Complexity: O(n)
# Space Complexity : O(len(p))