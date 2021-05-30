class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        '''
        Time Complexity: O(m+n)
        Space Complexity: O(n) 
        '''
        # KMP ALGORITHM
        if(needle == ""):
            return 0
        if(len(haystack)<len(needle)):
            return -1
        '''
        if(len(haystack)==len(needle)):
            if(haystack==needle):
                return 0
            else:
                -1
        '''
        x = [0 for i in range(0,len(needle))]
        j=0
        i=1
        while(i<len(needle)):
            if(needle[i]==needle[j]):
                j+=1
                x[i] = j
                i+=1
            else:
                if(j>0):
                    j = x[j-1]
                else:
                    x[i] = 0
                    i+=1
        
        j=0
        i=0
        
        while(i<len(haystack)):
            if(haystack[i]==needle[j]):
                i+=1
                j+=1
                if(j==len(needle)):
                    return i-j
            else:
                if(j>0):
                    j = x[j-1]
                else:
                    j=0
                    i+=1
        
        return -1
