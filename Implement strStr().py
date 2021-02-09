class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        #Approach: Linear Search
        #Time Complexity: O((lenH - lenN) * lenN)
        #Space Complexity: O(1)
        #where, lenH and lenN are the lengths of haystack and needle, respectively
        
        lenH, lenN = len(haystack), len(needle)
        
        for i in range(lenH - lenN + 1):
            if haystack[i : i + lenN] == needle:
                return i
            
        return -1