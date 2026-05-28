class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        m,n = len(haystack),len(needle)
        prev_n = 0 #to track prev_needle
        mod = 100001
        current_highest_power = 1 #current_highest_power = current highest power of 26 for that window
        prev_h = 0 #to track prev_haystack

        #needle
        for i in range(n):
            c = needle[i]
            curr=ord(c) - ord('a') + 1
            prev_n = (prev_n * 26 + curr) % mod
            current_highest_power = (current_highest_power * 26) % mod

        #haystack
        for i in range(m):
            c = haystack[i]
            curr=ord(c) - ord('a') + 1
            prev_h = (prev_h * 26 + curr) % mod

            if i >= n: 
                c_out = haystack[i - n]
                curr_out=ord(c_out) - ord('a') + 1
                prev_h = (prev_h - (current_highest_power * curr_out) % mod) % mod
                #prev_h -= (current_highest_power * curr_out)

            if prev_h < 0:
                prev_h += mod 
        #hash can become negative, and it shoulde be between 0 to mod-1,so -30 + 101 = 71

            if prev_h == prev_n:  
                #to avoid hash collision eg: "abc" → hash 731,"xyz" -> hash 731
                if i >= n - 1: 
                    if haystack[i - n + 1 : i + 1] == needle:  #actual str comparison 
                        return i - n + 1
        return -1
