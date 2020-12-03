# Time Complexity: O(N)
# Space Complexity: O(1)
# Approach: Use Rabin Karp algorithm to calculate a rolling hash for every substring (constant time) of the haystack and compare it with the rolling hash of the needle. Return the first matching index.
from functools import reduce
class Solution(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        return rabin_karp(haystack, needle)

def rabin_karp(t, s):
    if len(s) > len(t):
        return -1
    base = 26
    h_lambda = lambda h, c: h*base + ord(c)
    
    t_hash = reduce(h_lambda, t[:len(s)], 0)
    s_hash = reduce(h_lambda, s, 0)
    power = base ** max(len(s) - 1, 0)
    
    for i in range(len(s), len(t)):
        if t_hash == s_hash:
            return i - len(s)
        
        t_hash -= ord(t[i-len(s)]) * power
        t_hash = t_hash * base + ord(t[i])
        
    if t_hash == s_hash:
        return len(t) - len(s)
    
    return -1