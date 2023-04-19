# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        #brute force (mn)
        # for i in range(len(haystack)):
        #     if haystack[i] == needle[0]:
        #         x = i
        #         y = 0
        #         while(y < len(needle) and x < len(haystack)):
        #             if haystack[x] == needle[y]:
        #                 x += 1
        #                 y += 1
        #             else:
        #                 break
        #         if y == len(needle):
        #             return i
        # return -1

        #Rabin-Karp algorithm - Hash

        needleHash = 0
        haystackHash = 0
        m = len(haystack)
        n = len(needle)
        k = 26
        #k * n times max because outgoing char is multiplied by n times
        kn = (k**n)
        for i in needle:
            needleHash = needleHash*k+(ord(i)+1-ord('a'))
        
        for i in range(len(haystack)):
            haystackHash = haystackHash*k+(ord(haystack[i])+1-ord('a'))
            if i >= n:
                haystackHash = haystackHash-kn*(ord(haystack[i-n])+1-ord('a'))
            if haystackHash == needleHash:
                return i-n+1
        return -1