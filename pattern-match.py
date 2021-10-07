# // Time Complexity :O(n+m), n is the length of string and m is the length of pattern
# // Space Complexity :O(m) 
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach



class Solution:
    
    def strStr(self, haystack: str, needle: str) -> int:
        if len(needle)==0:
            return 0
        arr=self.commonprefix(needle)
        print(arr)
        i=0
        j=0
        while(i<len(haystack)):
            print(j)
            if haystack[i]==needle[j]:
                i=i+1
                j=j+1
                if j==len(needle):
                    return i-j
            else:
                if j>0:
                    j=arr[j-1]
                elif j==0:
                    i=i+1
            # print(i,j)
            # print(haystack[i],needle[j])
        return -1
                    
                
        
    def commonprefix(self,needle):
        arr=[0 for i in range(len(needle))]
        i=1
        j=0
        while i<len(needle):
            if needle[i]==needle[j]:
                j=j+1
                arr[i]=j
                i=i+1
            else:
                if j>0:
                    j=arr[j-1]
                elif j==0:
                    
                    arr[i]=0
                    i=i+1
            
        return arr
                    
            
        
        