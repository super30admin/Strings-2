class Solution(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        m = len(haystack)
        n = len(needle)

        prime = 10000000001
        pHash = 0
        for i in range(n):
            c = needle[i]
            pHash = (pHash * 26 + (ord(c) - ord('a') + 1)) % prime

        currHash = 0
        power = pow(26,n-1)

        for i in range(m):
            if(i >= n):
                ot = haystack[i-n]
                currHash = (currHash - power * (ord(ot) - ord('a') + 1)) % prime

            ip = haystack[i]
            currHash = (currHash * 26 + (ord(ip) - ord('a') + 1)) % prime

            if(currHash == pHash):
                return i-n+1

        return -1
            