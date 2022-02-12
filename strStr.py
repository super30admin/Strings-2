class Solution:
    
    def strStr(self, s: str, p: str) -> int:
        '''
        Time = O(M+N)
        Space = O(N)
        '''
        if not p: return 0
        
        if len(p) > len(s): return -1
        
        lps = self.build_lps(p)
        i = j = 0
        while i < len(s):
            if s[i] == p[j]:
                i += 1
                j += 1
                if j == len(p):
                    return i - len(p)
            else:
                if j > 0:
                    j = lps[j - 1]
                else:
                    i += 1
        return -1
    
    def build_lps(self, s: str) -> List[int]:
        lps = [0] * len(s)
        j, i = 0, 1
        while i < len(s):
            if s[i] == s[j]:
                lps[i] = j + 1
                i += 1
                j += 1
            else:
                if j > 0:
                    j = lps[j-1]
                else:
                    i += 1
        return lps
    
    def BruteForcestrStr(self, haystack: str, needle: str) -> int:
        '''
        Time Comp = O(m*n)
        Space = O(1)
        '''
        if not needle:
            return 0 
        l , r = 0 , len(needle)
        while r <= len(haystack):
            if haystack[l:r] == needle:
                return l 
            l += 1
            r += 1
        return -1
    

        
        
