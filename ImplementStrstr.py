-------------------------------- Find needle in haystack ---------------------------------------------
# Time Complexity : O(MXN)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No
# 
# First I will have a start pointer and end pointer and pointer 2 in my start of needle. when my start pointer in haystack is equal to
#first char of needle, then i will iterate through the needle and haystack at the same time and if my j is equal to k then return start.
# else I will just return my start, else increment my i pointer for next iteration.


class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        n = len(haystack)
        k = len(needle)
        
        if not needle or k == 0:
            return 0
 
        i = 0
        j = 0
        start = -1
        while i<n-k+1:
            
            while i< n-k+1 and haystack[i] != needle[0]:
                i +=1
                
            start = i
            t= i
            j = 0
            while j<k and t<n and haystack[t] == needle[j]:
                t +=1
                j +=1
                
            if j == k:
                return start
            i +=1
        return -1
        
-------------------------------- Find needle in haystack ---------------------------------------------
# Time Complexity : O(MXN)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No
# 
# First I will have a start pointer and end pointer where start is at 0 and end is at len(needle). I will check whether my 
# string is equal to needle or not, else I will increment start  and end both. I will repeat the same until my end pointer reaches end of haystack.
        
        
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if not needle:
            return 0
        if not haystack or len(haystack)<len(needle):
            return -1
 
        i = 0
        j = len(needle)
        start = -1
        while i<=len(haystack)-len(needle):
            if haystack[i:j] == needle:
                return i
            i +=1
            j +=1
        return -1
        
-------------------------------- Find needle in haystack ---------------------------------------------
# Time Complexity : O(MXN)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No
# 
# First I will have a start pointer and end pointer where start is at 0 and end is at len(needle). I will forst check if my start pointer is equal to needle[0] or not and  check whether my 
# string is equal to needle or not, else I will increment start  and end both. I will repeat the same until my end pointer reaches end of haystack.
        
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if not needle:
            return 0
        if not haystack or len(haystack)<len(needle):
            return -1
 
        for i in range(len(haystack)-len(needle)+1):
            if haystack[i] == needle[0] and haystack[i:i+len(needle)] == needle:
                return i
        
        return -1