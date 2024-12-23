class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        n = len(haystack)
        m = len(needle)
        arr = [0]
        i = 1
        j = 0
        while(i<m):
            if needle[i]==needle[j]:
                j = j + 1
                arr.append(j)
                i = i + 1
            elif needle[i] != needle[j] and j>0:
                j = arr[j-1]
            elif needle[i] != needle[j] and j==0:
                arr.append(0)
                i = i + 1
        i = 0
        j = 0
        while(i<n):
            if haystack[i] == needle[j]:
                i = i + 1
                j = j + 1
                if j == m:
                    return i - j
            elif haystack[i] != needle[j] and j>0:
                j = arr[j -1]
            else:
                i = i + 1
        return -1









        