# Time:O(m+n) for 2 strings
# Space:O(1) no extra space
# Leetcode: Yes
# Issues:None

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        # lower_priorities = OrderedDict(zip(string.ascii_lowercase, range(1,27)))
        m = len(haystack)
        n = len(needle)
        posFac = pow(26,n)                                          # 26^n
        pHash = 0
        # prime = 100001 can be used with modulo to not flip in non python env
        for i in range(n):                                          # Rabin Karps: rolling hash 1
            c = needle[i]
            pHash = pHash * 26 + (ord(c)-ord('a')+1)

        cHash = 0
        for i in range(m):                                          # Rabin Karps: rolling hash 2// siding window top element
            cin = haystack[i]
            cHash = cHash * 26 + (ord(cin)-ord('a')+1)
            
            if i >= n:                                              # sliding window initialized to remove last element
                cout = haystack[i-n]
                cHash = cHash - (posFac* (ord(cout)- ord('a')+1))         
            
            if cHash == pHash:                                                  
                return (i-n+1)

        return -1