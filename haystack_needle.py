class Solution:
    def strStr(self, haystack: str, needle: str) -> int:     
        # optimized 
        """
        keyIdea : KMP algorithm
        TC:O(m+n)
        SC:O(1)
        """
        if not needle or needle==haystack:return 0
        LPS=self.calc_LPS(needle)
        i,j=0,0
        while i<len(haystack):
            #case1
            if haystack[i]==needle[j]:
                i+=1
                j+=1
            #case2
                if j==len(needle):
                    return i-j
            #case3
            else:
                if j==0:i+=1
                else: j=LPS[j-1]
        return -1
    
    def calc_LPS(self,needle):
        LPS = [0]*len(needle)
        j = 0
        i = 1
        while i < len(needle):
            # case 1
            if needle[i] == needle[j]:
                j += 1
                LPS[i] = j
                i += 1
            # case 2
            elif j > 0 and needle[i] != needle[j]:
                j = LPS[j-1]
            # case 3
            elif j == 0 and needle[i] != needle[j]:
                LPS[i] = 0
                i += 1
        return LPS     
        
#         # Not optimized 
#         """
#         TC:O(m*n)
#         """
#         if needle == "": return 0
        
#         if needle not in haystack: return -1
#         for i in range(len(haystack)):
#             if haystack[i:i+len(needle)]==needle:
#                 return i
        
        