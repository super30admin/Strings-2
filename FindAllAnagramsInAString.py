'''
TC: O(n) - length of s since p will be smaller than or equal to s
SC: O(1) - we are only using bunch of pointers and ascii values to calculate
'''
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if len(s)<len(p):
            return []
        expected = 1
        for letter in p:
            expected *= ord(letter)
        expected_length = len(p)
        res = []
        total = 1
        for i in range(0,expected_length):
            total *= ord(s[i])
        l,r = 0,expected_length-1
        while r<len(s):
            if total == expected:
                res.append(l)
            if (r+1)<len(s):
                total*=ord(s[r+1])
                total = total//ord(s[l])
                l+=1
            r+=1
        return res
s = Solution()
print(s.findAnagrams())