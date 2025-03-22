# Time Complexity : O(n + m)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : YES

# Any problem you faced while coding this : NO

class RKSolution:
    def strStr(self, haystack: str, needle: str) -> int:
        power = 26 ** (len(needle) - 1)
        
        rk_needle_hash = 0
        for c in needle:
            c_val = ord(c) - ord('a') + 1
            rk_needle_hash = (rk_needle_hash * 26) + c_val

        rk_cur_hash = 0
        l = 0
        for r in range(len(haystack)):
            if r < len(needle):
                rk_cur_hash = (rk_cur_hash * 26) + (ord(haystack[r]) - ord('a') + 1)
                continue
            
            if rk_cur_hash == rk_needle_hash:
                return l

            # process outgoing
            l += 1
            rk_cur_hash = rk_cur_hash % power

            # process incoming
            rk_cur_hash = (rk_cur_hash * 26) + (ord(haystack[r]) - ord('a') + 1)

        if rk_cur_hash == rk_needle_hash:
            return l
        
        return -1

# Time Complexity : O(n + m)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : YES

# Any problem you faced while coding this : NO

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        lps_arr = self.lps(needle)
        
        i = 0
        j = 0

        while i < len(haystack):
            if haystack[i] == needle[j]:
                i += 1
                j += 1
                if j == len(needle):
                    return i - len(needle)
            elif haystack[i] != needle[j] and j != 0:
                j = lps_arr[j-1]
            elif haystack[i] != needle[j] and j == 0:
                j = 0
                i += 1
        
        return -1


    def lps(self, needle):
        lps = [0] * len(needle)
        j = 0
        i = 1
        while (i < len(needle)):
            if needle[j] == needle[i]:
                j += 1
                lps[i] = j
                i += 1
            elif needle[j] != needle[i] and j != 0:
                j = lps[j-1]
            elif needle[j] != needle[i] and j == 0:
                lps[i] = 0
                i += 1
        
        return lps