# solved using KMP algorithm
# time complexity is o(m) on an average, where m is the size of the input(haystack len is m in this problem)
# space is o(n), where n is size of the input(needle size is n in this problem)
   # --> lps_array size is n
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        m = len(haystack)
        n = len(needle)
        if(m < n):
            return -1
        i = 0
        j = 0
        lps_array = self.lps(needle) #space is o(n)
        while(i < m): # time is o(m)
            if(haystack[i] == needle[j]):
                i += 1
                j += 1
                if(j == n):
                    return i - n
            elif(haystack[i] != needle[j] and j > 0):
                j = lps_array[j-1]
            elif(haystack[i] != needle[j] and j == 0):
                i += 1
                
        return -1
            
   
    def lps(self, needle):
        n = len(needle)
        i = 1
        j = 0
        lps_array = [None for i in range(n)]
        lps_array[0] = 0
        while(i < n):
            if(needle[i] == needle[j]):
                j += 1
                lps_array[i] = j
                i += 1
            elif(needle[i] != needle[j] and j > 0):
                j = lps_array[j-1]
            elif(needle[i] != needle[j] and j == 0):
                lps_array[i] = 0
                i += 1
        return lps_array
                
                
        
    
        # needleSet = set()
        # needleSet.add(needle)
        # ln = len(needle)
        # lh = len(haystack)
        # if(ln > lh):
        #     return -1
        # for i in range(0, lh - ln + 1):
        #     if(haystack[i:i+ln] in needleSet):
        #         return i
        # return -1
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
#         if(needle == ''):
#             return 0
#         elif(needle in haystack):
#             for i in range(len(haystack)):
#                 if(needle==haystack[i:i+len(needle)]):
#                     return i
#         else:
#             return -1
        