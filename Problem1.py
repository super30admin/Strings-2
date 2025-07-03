"""
I used a single hashmap to store the frequency count of characters in the string p. As I iterated through s, I updated the hashmap and maintained a matchFound counter to track how many characters fully matched. When the window size exceeded p, I adjusted the hashmap for the outgoing character. If all characters matched (matchFound == len(hashMap)), I recorded the starting index.
Time Complexity: O(n + m)
Space Complexity: O(1)
"""
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:

        if len(s) < len(p) or len(s) == 0 or len(p) == 0:
            return []
        result = []
        hashMap = Counter(p)
        matchFound = 0
        for i in range(len(s)):
            char = s[i]
            #incoming character
            if char in hashMap:
                hashMap[char] -= 1
                if hashMap[char] == 0:
                    matchFound += 1
            
            #outgoing character
            if i >= len(p):
                if s[i - len(p)] in hashMap:
                    hashMap[s[i - len(p)]] += 1
                    if hashMap[s[i - len(p)]] == 1:
                        matchFound -= 1
            
            if matchFound == len(hashMap):
                result.append(i - len(p) + 1)
        return result