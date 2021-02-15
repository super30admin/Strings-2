#Time Complexity:O(m+n)
#Space Complexity:O(m)
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if len(needle)==0:
            return 0
        i=j=0
        lps=self.lps(needle)                                #create an lps array that holds the values of prefix and suffix values
        while i<len(haystack):
            if haystack[i]==needle[j]:                      #if the character of haystack and needle match at any point, increment both j and i anf j is same length as needle return i-j
                i+=1
                j+=1
                if j==len(needle):
                    return i-j
            elif j>0 and haystack[i]!=needle[j]:            #if characters dont match and j is not at the beginning of string reasign j value
                j=lps[j-1]
            elif j==0 and haystack[i]!=needle[j]:           #if j is at beginning of string and characters dont match increment i value
                i+=1
        return -1
        
    def lps(self,needle:str)->List[int]:
        j=0                                                 #let j be at first position and i at second 
        i=1
        lps=[None]*len(needle)                              #create an lps array same size as needle
        lps[0]=0                                            #first index always holds a zero
        while(i<len(needle)):                               #while i is less than length of needle
            if needle[i]==needle[j]:                        #if the characters at i and j in needle string are same incremt j assign j value to the ith position in lps and increment i
                j+=1
                lps[i]=j
                i+=1
            elif j>0 and needle[i]!=needle[j]:              #if j is not at the first position and j and i characters dont match reassign j value 
                j=lps[j-1]
            elif j==0 and needle[i]!=needle[j]:             #if j is at the first position and charcters at i and j dont match increment i after assign 0 at the ith poition
                lps[i]=0
                i+=1
        return lps                                          #return the laps array to the calling function