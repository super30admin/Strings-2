class Solution:
    def strStr(self, haystack: str, needle: str) -> int:

        def buildPattern(string):
            
            arr = [-1]*len(string)
            
            j, i = 0, 1
            
            while i<len(string):
                if string[i] == string[j]:
                    arr[i] = j
                    i+=1
                    j+=1
                elif j>0:
                    j = arr[j-1]+1
                else:
                    i+=1
            return arr
        
        arr = buildPattern(needle)
        
        i, j = 0, 0
        if len(needle) == 0:
            return 0
        while i<len(haystack):
            if haystack[i] == needle[j]:
                i+=1
                j+=1
                if j==len(needle):
                    return i-j
            elif j>0:
                j = arr[j-1]+1
            else:
                i+=1
        return -1 
    
Time: O(m+n)
Space: O(m)
