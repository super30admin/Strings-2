class Solution(object):
    def strStr(self, haystack, needle):

        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        m = len(haystack)
        n = len(needle)
        if (n==0):
            return 0
        i = 0
        j = 0
        while(i<m):
            if(haystack[i] == needle[j]):
                temp = i
                while(temp < m and j<n):
                    if(haystack[temp] == needle[j]):
                        temp+=1
                        j+=1
                    else:
                        break
                    if(j==n):
                         return i
            j=0
            i+=1
        return -1
