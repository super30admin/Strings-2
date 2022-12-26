'''
Time Complexity --> O(n*m) where n is the length of the haystack and m is length of needle
Space Complexity --> O(n) of the haystack

'''
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if len(haystack)<len(needle):
            return -1
        ls = []
        for i in range(len(haystack)):
            if haystack[i]==needle[0]:
                ls.append(i)
        
        for v in ls:
            ind = v
            j = 0
            f = 0
            if v+len(needle)>len(haystack):
                f = 1
                break
            for i in range(v, v+len(needle)):
                if haystack[i]==needle[j]:
                    j+=1
                    continue
                else:
                    f = 1
                    break
            if f==0:
                return ind
        return -1
            


            
