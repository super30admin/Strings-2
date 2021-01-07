"""
Approach: Using sliding window and hashmap

Here we will use a sliding window of size p. 
Intially we will also use a hashmap that we will contain all the characters in string p as key and their frequencies as value.

Also we will encounter 2 cases here when we slide ahead:

1) An incoming character: Decrement the count of current character from hashamap. If its equal to then we have found a character match. If not then just update the value of the decremented count for that character in hashmap. Also if such match is found we will increment our match value.

2) An outgoing character: Here outgoing character would be the character that was removed when the window moves forward. If the outgoing character was present in the hashmap then we need to increase its count value because it is no longer under consideration. Also decrement the match value if the count for that character becomes 1.

Remember here a count = 0 says a match is found and count = 1 says match is gone or no longer available.

At any point in above two cases if value of match becomes eqaual to lenght of string p then return starting index of the current window.

TC: O(n) 
SC: O(1)

where n = length of string s
"""

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        self.result = []

        if s == None or len(s) == 0:
            return self.result
        
        # Create hashmap
        hmap = {}
        for i in p:
            if i not in hmap:
                hmap[i] = 1
            else:
                hmap[i] += 1
        
        match = 0
        for i in range(len(s)):
            c = s[i]
            
            #incoming
            if c in hmap:
                count = hmap[c]
                count -= 1
                if count == 0:
                    match += 1
                
                hmap[c] = count
            
            #outgoing
            if i >= len(p):
                outgoing = s[i - len(p)]
                if outgoing in hmap:
                    count = hmap[outgoing]
                    count += 1
                    if count == 1:
                        match -= 1
                    hmap[outgoing] = count
                    
            if match == len(hmap):
                self.result.append(i - len(p) + 1)
                
        return self.result
        