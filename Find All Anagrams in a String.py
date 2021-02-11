class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        #Approach: Backtracking, followed by Linear Search
        #Time Complexity: O(X * (lenS - lenP) * lenP)
        #Space Complexity: O(1)
        #where, lenS and lenP are the lengths of s and p, respectively
        #and, X is the total number of anagrams of p (roughly factorial, but could be way less)
        
        pCount = {}
        for char in p:
            pCount[char] = pCount.get(char, 0) + 1
        
        self.result = []
        self.helper(s, len(p), pCount, 0, [])
        return self.result
    
    def helper(self, s, pLen, pCount, idx, path):
        #base
        if len(path) == pLen:
            self.strStr(s, ''.join(path))
        
        #logic
        for char in pCount:
            #action
            if pCount.get(char, 0) > 0:
                path.append(char)
                pCount[char] = pCount.get(char, 0) - 1
                
                #recursion
                self.helper(s, pLen, pCount, idx + 1, path)
                
                #backtracking
                path.pop()
                pCount[char] = pCount.get(char, 0) + 1
                
    def strStr(self, s, sub):
        lenS, lenSub = len(s), len(sub)
        for i in range(lenS - lenSub + 1):
            if s[i : i + len(sub)] == sub:
                self.result.append(i)