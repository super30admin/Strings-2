class Solution:
    
    # Using HashMap 
    # TC: O(n-m) --> n and m are length of string s and p respectively {2(n-m)}
    # SC: O(m) --> HashMap
    
    def findAnagrams(self, s: str, p: str) -> List[int]:
        result = []
        
        if (s == None or len(s) == 0 or len(p) > len(s)):
            return result
        
        hashmap = dict()
        
        for char in p:
            if char not in hashmap:
                hashmap[char] = 1
            else:
                hashmap[char] += 1
                
        match = 0
        
        for i in range(len(s)):
            char = s[i]
            
            # In
            if (char in hashmap):
                hashmap[char] = hashmap[char] - 1
                if (hashmap.get(char) == 0): # 1 --> 0
                    match += 1
            # Out
            if (i >= len(p)): 
                charOut = s[i-len(p)]
                    
                if (charOut in hashmap):
                    hashmap[charOut] = hashmap[charOut] + 1
                    if (hashmap[charOut] == 1): # 0 --> 1
                        match -= 1
            
            if (match == len(hashmap)):
                result.append(i - len(p) + 1)
                    
        return result