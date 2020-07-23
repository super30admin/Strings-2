"""
// Time Complexity : o(m+n), m -> length of needle, n-> length of haystack
// Space Complexity : o(m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
"""

class Solution:
    def lps(self, needle): #function to find the longest prefix suffix array for pattern
        lps_arr = [0] * len(needle)
        lps_arr[0] = 0 #for first character
        
        i = 1
        j = 0
        
        while i < len(needle):
            #case1 
            if needle[i] == needle[j]:
                j += 1 #increment j and put that value at i if chars at i and j are the same and increment i
                lps_arr[i] = j
                i += 1
            #case2
            elif j > 0 and needle[i] != needle[j]: #unequal case
                j = lps_arr[j-1] #go to previous j location
            #case3 
            elif j == 0 and needle[i] != needle[j]: #if j cant go further back which means there is no matching prefix, put 0 at i and increment i 
                lps_arr[i] = 0
                i += 1
        return lps_arr
    
    def strStr(self, haystack: str, needle: str) -> int:
        
        if not needle:
            return 0
        n = len(haystack)
        m = len(needle)
        
        if m > n: #if needle is longer than haystack, no solution
            return -1
        lps_arr = self.lps(needle) #get the lps array
        
        i = j = 0 #pointers for haystack and needle
        
        while i < n: #for length of haystack
            
            if needle[j] == haystack[i]: #if theres a match increment both pointers
                i += 1
                j += 1
            
            if j == m: # if entire needle string has been iterated over, match has been found, return starting index by subtracting length of the needle
                return i - m
            
            if i < n and j > 0 and needle[j] != haystack[i]: #if theres a mismatch of chars, go to lps index at j-1  
                j = lps_arr[j-1]
                
            elif i < n and j == 0 and needle[j] != haystack[i]: # if j == 0, we are at beginning of the needle, no match found at i so just increment i
                i = i+1
                
        return -1
        
            
            
        