# Time Complexity : O(m+n) where m is the length of haystack and n is the length of the needle
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
# I first create a prefix suffix array on the needle and the use it to search on the haystack where on a mismatch we go back the previous index where the
# prefix match the current element

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if len(needle) == 0: return 0
        if len(haystack) == 0: return -1
        
        lps = self.pi_func(needle)
        length = len(haystack)
        h = 0
        n = 0
        while h < length:
            if haystack[h] == needle[n]:
                h+=1
                n+=1
                if n == len(needle):
                    return h - n
            elif n > 0 and haystack[h] != needle[n]:
                n = lps[n-1]
            elif n == 0 and haystack[h] != needle[n]:
                h+=1
        return -1
    
    def pi_func(self, needle):
        length = len(needle)
        arr = [0 for x in range(length)]
        left, right = 0, 1
        while right < length:
            if needle[left] == needle[right]:
                left+=1
                arr[right] = left
                right+=1
            elif left > 0 and needle[left] != needle[right]:
                left = arr[left-1]
            elif left == 0 and needle[left] != needle[right]:
                arr[right] = 0
                right+=1    
        return arr
