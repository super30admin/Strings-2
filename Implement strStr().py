class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        #Approach: Knuth–Morris–Pratt (KMP) algorithm
        #Time Complexity: O(lenH + lenN)
        #Space Complexity: O(lenN)
        #where, lenH and lenN are the lengths of haystack and needle, respectively
        
        lenH, lenN = len(haystack), len(needle)
        if not lenN:
            return 0
        
        lps = self.lps(needle)
        print(lps)
        
        i, j = 0, 0
        while i < lenH:
            if haystack[i] == needle[j]:
                i += 1
                j += 1
                
                if j == lenN:
                    return i - j
            
            elif j > 0 and haystack[i] != needle[j]:
                j = lps[j - 1]
            
            else:   #j == 0
                i += 1
        
        return -1
    
    def lps(self, needle):      #longest prefix-suffix
        lps = [0 for _ in needle]
        i, j = 1, 0
        
        while i < len(needle):
            if needle[i] == needle[j]:
                j += 1
                lps[i] = j
                i += 1
            elif j != 0 and needle[i] != needle[j]:     #not moving i; so it works like while
                j = lps[j - 1]
            else:   # j == 0
                lps[i] = 0
                i += 1
        return lps
            
    #Solution 2:
    """
    def strStr(self, haystack: str, needle: str) -> int:
        #Approach: Linear Search
        #Time Complexity: O((lenH - lenN) * lenN)
        #Space Complexity: O(1)
        #where, lenH and lenN are the lengths of haystack and needle, respectively
        
        lenH, lenN = len(haystack), len(needle)
        
        for i in range(lenH - lenN + 1):
            if self.isMatch(haystack, needle, i):
                return i
            
        return -1
    
    def isMatch(self, str1, str2, i):
        for j in range(len(str2)):
            if i + j >= len(str1) or str1[i + j] != str2[j]:
                return False
        
        return True
    """