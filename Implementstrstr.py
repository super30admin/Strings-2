#28. Implement strStr()

"""
Time Complexity : O(len(haystack) * len(needle))
Space Complexity : O(1)
"""

"""
    BRUTE FORCE APPROACH
"""

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if len(haystack) < len(needle):
            return -1
        
        store = 0
        i = 0 #haystack
        j = 0 #needle
        
        while i <= len(haystack) - len(needle):
            #print("i", i)
            if haystack[i] != needle[0]:
                i += 1
            
            else:
                store = i
                j = 0
                while j < len(needle):
                    if haystack[i] == needle[j]:
                        j += 1
                        i += 1
                        #print(i, j)
                    
                    else:
                        i = store + 1
                        j = 0
                        break
                        
                #print("here", store, j)
                if j == len(needle):
                    #print("h", store)
                    return store
                else:
                    j = 0
        return -1
        
