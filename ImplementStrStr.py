# Time Complexity:
# O(m*n) , m = lenght of "haystack", n = length of "needle""

# Space Complexity:  
# O(1)

# Approach: 
# Linear iteration over the lenght of haystack string.


class Solution(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        if not haystack or len(haystack)==0:
            return -1

        lenNeedle = len(needle)
        lenHay = len(haystack)
        
        l = 0
        startChar = needle[0]

        for i in range(lenHay):
            if haystack[i] == startChar:
               # check the substring of lenght "lenNeedle"
               if haystack[i:i+lenNeedle] == needle:
                    return i
                    
        return -1      