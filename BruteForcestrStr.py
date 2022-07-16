#Time complexity : O(mn) where n is length of pattern and m is the length of source
#Space complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#youtube : https://youtu.be/J50u_XbJDj8
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        #source string
        m = len(haystack)
        #pattern string
        n = len(needle)
        if n>m:
            return -1
        #defining 2 pointers for traversing 2 strings
        i = 0
        j = 0
        #iterating loop on the source string till the index reahes m-n i.e m is length of source string and n is length of pattern strick
        while i<= m-n:
            if haystack[i] == needle[j]:
                #once the string is match to keep track of i we will keep use another variable for traversing in source
                k = i
                #if charater at i in sourse matches with the pattern character at j then we will increase the index in for pattern and string source
                while haystack[k] == needle[j]:
                    k+=1
                    j+=1
                    #checking if the j have match all the pattern
                    if j==n:
                        #returning the starting index if whole pattern is match with string
                        return i
                #if there is no match then we will increase the source pointer and reset the pointer for source pattern
                j = 0
            i +=1
            
    
        return -1
        
