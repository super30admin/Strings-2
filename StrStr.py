# Time Complexity : O(n)
# Space Complexity : O(1)
# The code ran on LeetCode

# Rolling Hash. Compute rolling hash for the needle with the multiplicative factor of 26. Move a sliding window over the haystack to find where the hash value matches to that of the needle

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        
        needle_hash = 0
        n = len(needle); k = 26
        for ne in needle:
            val = ord(ne) - ord('a') + 1
            needle_hash = needle_hash*k + val
        check = 0
        for i in range(len(haystack)):
            val = ord(haystack[i]) - ord('a') + 1
            if i < n:
                check = check * k + val
            else:
                incoming = haystack[i]
                outgoing = ord(haystack[i - len(needle)]) - ord('a') + 1

                check = check * k + ord(incoming) - ord('a') + 1
                check -= outgoing*(k**n)
            print(check, needle_hash, i)
            if check == needle_hash:
                
                return i - n + 1
        return -1
