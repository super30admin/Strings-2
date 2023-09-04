#TC:  O(n + m)
#SC: O(m)

class KMP:
    
    def __computePI(self, needle: str) -> List[int]:
        
        pi = [0 for i in range(len(needle))]
        j = 0
        i = 1
        
        while (i < len(needle)):
            
            if (needle[i] == needle[j]):
                j += 1
                pi[i] = j
                i += 1
            
            else:
                if (j == 0):
                    i += 1
                else:
         
                    j = pi[j - 1]

        return pi
    
    def strStr(self, haystack: str, needle: str) -> int:
        
        if (len(needle) == 0):
            return 0
        
        hs = len(haystack)
        n = len(needle)
        pi = self.__computePI(needle)
        
        i = 0
        j = 0

        while (i < hs):
            
            if (haystack[i] == needle[j]):
                i += 1
                j += 1
                if (j == n):           
                    return i - j
               
            else:
                if (j == 0):
                    i += 1
                else:
                    j = pi[j - 1]
                   
        return -1
            