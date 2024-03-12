'''
TC: O(m*n) - m is the length of haystack and n is the length of needle
SC: O(len(needle))
'''
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if len(haystack)<len(needle):
            return -1
        expected = ""
        for letter in needle:
            expected = expected + str(ord(letter))
        expected_length = len(needle)
        res = []
        total = ""
        for i in range(0,expected_length):
            total = total+str(ord(haystack[i]))
        l,r = 0,expected_length-1
        while r<len(haystack):
            if int(total) == int(expected):
                return l
            if (r+1)<len(haystack):
                total=total+str(ord(haystack[r+1]))
                k = len(str(ord(haystack[l])))
                while k>0:
                    total = total[1:]
                    k-=1
                l+=1
            r+=1
        return -1
s = Solution()
print(s.strStr("sadbutsad", "sad"))
print(s.strStr("leetcode", "leeto"))
print(s.strStr("leetcode", "etc"))
print(s.strStr("aaa", "aaaa"))