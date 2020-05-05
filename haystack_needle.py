"""
// Time Complexity : O(len(haystack)) //O(1) slicing using rolling hash method 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
Algorithm Explanation
Given below
"""

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        """
        Rabin Karp approach 
        1) Convert the strings to corresponding integer values for affecting the slicing to be O(1)
        2) Compute the hash of haystack and needle
        3) If the hash match, return the start position
        4) Compute the rolling hash using the previous hash and the relation using the coefficient used for computing the hash ho
        """
        H = len(haystack)
        N = len(needle)
        
        a = 26
        mod = 2**31
        
        h_int = lambda x: ord(haystack[x]) - ord('a')
        n_int = lambda x: ord(needle[x]) - ord('a')
        
        
        h_hash = ref_hash = 0
        for i in range(N):
            h_hash = (h_hash*a + h_int(i)) % mod
            ref_hash = (ref_hash*a + n_int(i)) % mod
        if h_hash == ref_hash:
            return 0
        
        #Computing the rolling hash based on sliding window principle on ints
        
        an = pow(a,N,mod)
        
        for i in range(1, H - N + 1):
            h_hash = (h_hash*a - h_int(i-1) * an + h_int(i+N-1)) % mod
            if h_hash == ref_hash:
                return i
        return -1
        
        