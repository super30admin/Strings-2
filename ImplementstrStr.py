class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        """to get better solution use KMP Algorithm
        Time complexity-O(m+n)
        Space complexity-O(1)"""
        if not needle:
            return 0
        if haystack==needle:
            return 0
        arr=self.needleStr(needle)
        i=0
        j=0
        while i<len(haystack):            
            if haystack[i]==needle[j]:
                i+=1
                j+=1
            elif haystack[i]!=needle[j] and j>0:
                j=arr[j-1]
            elif haystack[i]!=needle[j] and j==0:
                i+=1
            if j==len(needle):
                return i-len(needle)
            
        return -1
            
            
    
    def needleStr(self, needle):
        j=0
        i=1
        arr=[]
        arr.append(0)
        while i<len(needle):
            if needle[j]==needle[i]:
                j+=1
                arr.append(j)
                i+=1
            elif needle[j]!=needle[i] and j>0:
                j=arr[j-1]
            elif needle[j]!=needle[i] and j==0:
                arr.append(0)
                i+=1
        return arr
                
            
        
        
        """Brute Force Optimized Solution
        Time complexity-O(m*n)
        Space complexity-O(1)"""
        # if len(needle)==0:
        #     return 0
        # i=0
        # n=len(haystack)
        # m=len(needle)
        # while i<n-m+1:
        #     if haystack[i]==needle[0]:
        #         j=i
        #         k=0
        #         while j<n and k <m and haystack[j]==needle[k]:
        #             j+=1
        #             k+=1
        #             if k==m:
        #                 return i
        #     i+=1
        # return -1
        