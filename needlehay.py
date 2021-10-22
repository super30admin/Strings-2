class Solution:
    # TC O(m+n)
    # SC O(n)
    def strStr(self, haystack: str, needle: str) -> int:
        if needle is None or len(needle) == 0:
            return 0
       
        def createLps( arr):
            lps = [0]* len(arr)
            i = 1
            j = 0
            while ( i < len(arr)):

                #Case1
                if arr[i] == arr[j]:
                    j += 1
                    lps[i]=j
                    i += 1

                #Case2
                elif arr[i] != arr[j] and j > 0:
                    j = lps[j-1]
                
                #Case3
                else:
                    lps[i]=0
                    i+=1
            return lps
        lps = createLps(needle)
        m = len(haystack)
        i = 0 # in haystack
        j = 0 # in needle
        n = len(needle)
        while ( i < m):
            if (haystack[i] == needle[j]):
                i += 1
                j += 1
                if j == n:
                    return i - n
            elif haystack[i] != needle[j] and j > 0:
                j = lps[j-1]
            else:
                i +=1
        return -1
                
        
        
        
