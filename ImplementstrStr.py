#All TC passed on leetcode

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:

        #Robbin Karp approach. We find the hash of every substring of haystack and check if hash any of them match with hash of needle string.
        #Time complexity - O(n+m) => O(m) where m-length of haystack and n is length of needle. The length of haystack is greater than needle else we return -1 at the beginning
        #Space complexity - O(1)
        if len(needle)>len(haystack):
            return -1

        k = 26
        kl = pow(26,len(needle))

        hash_needle = 0
        for i in range(len(needle)):
            hash_needle = hash_needle*k + (ord(needle[i])-ord('a'))
        
        hash_haystack = 0
        for i in range(len(needle)):
            hash_haystack = hash_haystack*k + (ord(haystack[i])-ord('a'))

        if hash_haystack==hash_needle:
            return 0
        
        for i in range(1, len(haystack)-len(needle)+1):

            out_char = haystack[i-1]
            in_char = haystack[i+len(needle)-1]

            hash_haystack = hash_haystack*k + (ord(in_char)-ord('a'))
            hash_haystack = hash_haystack - kl*(ord(out_char)-ord('a'))

            if hash_haystack == hash_needle:
                return i
        
        return -1







#-------------------------------------------OR----------------------------------------------------


        #KMP approach. We find the longest prefix suffix for needle and then for haystack.
        #Time complexity - O(n+m) => O(m) where m-length of haystack and n is length of needle. The length of haystack is greater than needle else we return -1 at the beginning
        #Space complexity - O(n) - array to hold lps of needle 
        if len(needle)>len(haystack):
            return -1

        lps_needle = [0]*len(needle)
        j=0
        i=1
        while i<len(needle):
            if needle[i]==needle[j]:
                j+=1
                lps_needle[i] = j
                i+=1
            elif needle[i]!=needle[j] and j>0:
                j = lps_needle[j-1]
            elif needle[i]!=needle[j] and j==0:
                lps_needle[i] = 0
                i+=1
        
        i=0
        j=0
        while i<len(haystack):
            if haystack[i]==needle[j]:
                j+=1
                i+=1
                if j==len(needle):
                    return i-len(needle)
            elif haystack[i]!=needle[j] and j>0:
                j = lps_needle[j-1]
            elif haystack[i]!=needle[j] and j==0:
                i+=1
        return -1



#-------------------------------------------OR----------------------------------------------------

        #Brute force way of comparing every substring of haystack with needle
        #Time complexity - O(n^2)
        #Space complexity - O(1)
        if len(needle)>len(haystack):
            return -1

        for i in range(len(haystack)-len(needle)+1):
            if haystack[i:i+len(needle)]==needle:
                return i
        return -1

#-----------------------------------------OR------------------------------------------------------

        #Brute force way of comparing every substring of haystack with needle using 2 for loops
        #Time complexity - O(n^2)
        #Space complexity - O(1)

        if len(needle)>len(haystack):
            return -1

        for i in range(len(haystack)-len(needle)+1):
            k=i
            for j in range(len(needle)):
                if haystack[k]==needle[j]:
                    k+=1
                    if j==len(needle)-1:
                        return i
                else:
                    break
            

            # if haystack[i:i+len(needle)]==needle:
            #     return i
        
        return -1

        