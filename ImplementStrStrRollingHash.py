'''
TC: O(n) = n is the length of the haystack 
            since it will always be greater than needle
SC: O(1)
'''
#RobinCorp Algorithm
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if len(needle)>len(haystack):
            return -1
        expected = 0
        for letter in needle:
            order = ord(letter)-ord('a')
            if order>9:
                expected = expected*100 + order
            else:
                expected = expected*10 + order
        l,r = 0,len(needle)
        total = 0
        for i in range(l,r):
            order = ord(haystack[i])-ord('a')
            if order>9:
                total = total*100 + order
            else:
                total = total*10 + order
        l,r = 0,len(needle)-1
        while r<len(haystack):
            if total == expected:
                return l
            string_integer = str(total)
            order_l = ord(haystack[l])-ord('a')
            if order_l>9:
                zeros = len(string_integer)-2
                n = order_l*10**zeros
            else:
                zeros = len(string_integer)-1
                n = order_l*10**zeros
            total = total-n
            l+=1
            if r+1<len(haystack):
                order_r = ord(haystack[r+1])-ord('a')
                if order_r>9:
                    total = total*100+order_r
                else:
                    total = total*10+order_r
            r+=1
        return -1
s = Solution()
print(s.strStr("sadbutsad", "sad"))
print(s.strStr("leetcode", "leeto"))
print(s.strStr("leetcode", "etc"))
print(s.strStr("aaa", "aaaa"))