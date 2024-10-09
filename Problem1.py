'''
1. If no needle string is given return 0. If needle's length is greater than haystack's there is no chance of finding it so return -1
2. Iterate over the haystack and find that index where the string of needle's length equals needle. 
3. Return that index. Else return -1

TC: O(n)
SC: O(1)
'''
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        
        if not needle or len(needle) == 0:
            return 0

        if len(haystack) < len(needle):
            return -1
        

        for i in range(len(haystack)):
            if haystack[i:i+len(needle)] == needle:
                return i
        return -1