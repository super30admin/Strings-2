#HayStack and Needle

#BruteForce:
#TC: O(N^2)
#SC:O(1)
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if len(haystack)==1:
            return haystack.index(needle)
        for i in range(0, len(haystack)):
            for j in range(i+1, len(haystack)+1):
                word = haystack[i:j]
                if len(word)==len(needle):
                    if word == needle:
                        return i
        
        return -1
        
        

#Again Brute Force
#TC: O(m*n)
#SC: O(1)
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        #2pointer solution
        if len(needle)>len(haystack):
            return -1
        i=0
        while(i<= len(haystack)-len(needle)): # i greater than different will not have enough length to match the needle string
            k = i
            j=0
            while(haystack[k]==needle[j]):
                j = j+1
                k = k+1
                if j == len(needle):
                    return i
            
            i = i+1
        
        return -1
        

#Rabin karp - String pattern algorithm
#TC: O(m+n)
#SC: O(1)
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        hash_needle = 0
        for n in needle:
            hash_needle = hash_needle*26 + ord(n)-ord('a')+1
        
        hash_hay = 0
        for index,h in enumerate(haystack):
            hash_hay = hash_hay*26 + (ord(h) - ord('a')+1)
            if index >= len(needle):
                outgoing =  ord(haystack[index-len(needle)]) - ord('a')+1
                hash_hay = hash_hay - (26**len(needle))*outgoing 
            if hash_hay == hash_needle:
                return index - len(needle)+1
        
        return -1