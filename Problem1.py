class Solution:
    def strStr(self, haystack: 'str', needle: 'str') -> 'int':
    	# Time Complexity : O(n) where n is the length of haystack because we are going through each and every character in haystack
    	# Accepted on Leetcode
        for i in range(len(haystack) - len(needle) + 1):
            if(haystack[i:i+len(needle)] == needle):
                return i
        return -1