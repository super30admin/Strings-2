# Time: O(m + n) 
# Space: O(1) since we have a only 26 max chars in dictionary

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        # Base case
        if not s or len(s) < len(p):
            return []
        
        result = []
        dic = {}
        match = 0
        
        # Count the char in p string and store it as value
        for char in p:
            if char not in dic:
                dic[char] = 1
            else:
                dic[char] += 1
        
        for i in range(len(s)):
            # Incoming char
            if s[i] in dic:
                dic[s[i]] -= 1
                if dic[s[i]] == 0: # Matched one char
                    match += 1
            # Outgoing char 
            if i >= len(p): # meaning slide the window since i is >= length of p
                char_out = s[i - len(p)]
                if char_out in dic:
                    dic[char_out] += 1  # I need a char so increment it.
                    if dic[char_out] == 1: # Meaning don't have a match
                        match -= 1
             
            # if match == len(dic) means I have a perfect anagram
            if match == len(dic):
                result.append(i - len(p) + 1) # if you remove you will get -1 
                
        return result
