class Solution(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """

        #         if needle not in haystack:
        #             return -1
        #         if len(needle)==0:
        #             return 0
        #         i=0
        #         j=0
        #         while i<len(haystack)-len(needle)+1:
        #             k=i
        #             j=0
        #             while k<len(haystack) and haystack[k]==needle[j]:
        #                 k+=1
        #                 j+=1
        #                 if j==len(needle):
        #                     return i
        #             i+=1

        #         return 0
        # time-O(len(haystack)**2) space-O(1)
        def lps(needle):
            i = 1
            j = 0
            lps = [0] * len(needle)
            while i < len(needle):
                if needle[i] == needle[j]:
                    j += 1
                    lps[i] = j
                    i += 1
                else:
                    if j > 0:
                        j = lps[j - 1]
                    elif j == 0:
                        lps[i] = 0
                        i += 1
            return lps

        if len(needle) > len(haystack):
            return -1
        if len(needle) == 0:
            return 0
        lps = lps(needle)
        i = 0
        j = 0
        while i < len(haystack):
            if haystack[i] == needle[j]:
                i += 1
                j += 1
                if j == len(needle):
                    return i - len(needle)
            elif haystack[i] != needle[j] and j > 0:
                j = lps[j - 1]
            elif haystack[i] != needle[j] and j == 0:
                i += 1
        return -1
    # time-O(2*len(haystack)) space-O(len(needle))