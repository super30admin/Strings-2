# APPROACH  1: BRUTE FORCE
# Time Complexity : O(nm), n: len(haystack), m: len(needle)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Edge case: if haystack is empty or length of haystack is less than that of neede return 0
# 2. Have two pointers - one to traverse haystack and other for needle. Also maintain a start ptr to mark the start of the current window (to return).
# 3. If char at both ptrs are same -> inc both. check if we reached end of needle, if so return start ptr
# 4. If char at both ptr is not same, then set needle traverse ptr back to 0, and inc start and set traverse haystack ptr to start (checking the next possible window)

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        
        if len(needle) == 0: 
            return 0
        
        if len(haystack) == 0 or len(haystack) < len(needle):
            return -1
        
        start, curr_h, curr_n = 0, 0, 0
        
        while curr_h < len(haystack):
            if haystack[curr_h] == needle[curr_n]:
                curr_h += 1
                curr_n += 1
                
                if curr_n == len(needle):
                    return start
                
            else:
                start += 1
                curr_h = start
                curr_n = 0
                
        return -1
        
        
        
        
# APPROACH 2: OPTIMAL APPROACH: KMAP ALGORITHM 
# Time Complexity : O(n + m), n: len(haystack), m: len(needle)
# Space Complexity : O(m) to store lps
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Firstly create lps (longest prefix suffix array) for needle
#       - have 2 pts j, i to mark the ends of the current window considered to count the length of equal prefix and suffix subarrays. 
#       - if the char at both i and j is same, inc j, set lps at that point to j, inc i
#       - if the char is not same and j > 0 (chances for decreasing the window size), set j to that point which is just previously matched (from prev lps entry) and we start 
#         matching from there.
#       - if the char is not same and j = 0 (all chances of having a window is tried out and there are none left), set lps at that point to 0 and inc i. 
# 2. Now, have two pointers - one to traverse haystack and other for needle. 
# 3. If char at both ptrs are same -> inc both. check if we reached end of needle, if so return start ptr
# 4. If char at both ptr is not same -> if the ptr at needle is > 0, then set it to previous matched window (from it's lp entry as we know that we have already checked that many 
#                                       chars of haystack and needle which are the same) and continue the check from there
#                                   -> if the ptr at needle is 0, means no chars beofre the current match the needle, then inc haystack ptr 

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        
        if len(needle) == 0: 
            return 0
        
        if len(haystack) == 0 or len(haystack) < len(needle):
            return -1
        
        lps = self.create_lps(needle)
        curr_h, curr_n = 0, 0
        
        while curr_h < len(haystack):
            if haystack[curr_h] == needle[curr_n]:
                curr_h += 1
                curr_n += 1
                if curr_n == len(needle):
                    return curr_h - len(needle)
                
            elif curr_n > 0 and haystack[curr_h] != needle[curr_n]:
                curr_n = lps[curr_n - 1]
            elif curr_n == 0 and haystack[curr_h] != needle[curr_n]:
                curr_h += 1
                
        return -1
        
        
    def create_lps(self, needle):
        j, i, lps = 0, 1, [None for _ in range(len(needle))]
        lps[0] = 0
        
        while i < len(needle):
            if needle[j] == needle[i]:
                j += 1
                lps[i] = j
                i += 1
                
            elif j > 0 and needle[j] != needle[i]:
                j = lps[j - 1]
                
            elif j == 0 and needle[j] != needle[i]:
                lps[i] = 0
                i += 1
                
        return lps
