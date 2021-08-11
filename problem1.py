class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if len(needle)>len(haystack):
            return -1
        if len(needle)==0 and len(haystack)==0:
            return 0
        if len(needle)==len(haystack) and needle==haystack:
            return 0
        window=len(needle)
        
        for i in range(0,len(haystack)-window+1):
            
            st=haystack[i:i+window]
            
            if st==needle:
                return i
        return -1
       #Time O(n*n*m), n=len(haystack),m=len(needle)
        #Space O(n+m), string copy space
                
