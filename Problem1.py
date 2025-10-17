"""
TC: O(H plus L) The time complexity is linear with respect to the length of the haystack H and the needle L. We perform an initial O(L) pass to calculate the needle's hash, and then a single O(H) pass to calculate and check the rolling hash.
SC: O(1) The space complexity is constant as we only store a few variables for hash values and coefficients.

Approach:

This problem is solved using the Rabin-Karp algorithm with a Rolling Hash technique for efficient substring searching. The goal is to find the first occurrence of the {needle} within the {haystack}.

1.  Hash Calculation: We calculate the hash value of the {needle} once. We treat characters as digits in a base-26 number system, using their ASCII values as coefficients.
2.  Rolling Hash: Instead of recalculating the hash for every substring in the {haystack}, we use a rolling hash to update the current hash value in O(1) time as the window slides one position to the right.
    * Roll Out: When the window moves, the character leaving the window on the left is subtracted from the hash, scaled by the highest power of 26 (26^{L-1}).
    * Roll In: The new character entering the window on the right is added to the hash after the entire hash is multiplied by 26, effectively shifting all existing characters to the left.
3.  Comparison: We compare the rolling hash of the {haystack} substring with the pre-calculated hash of the {needle}. When the hashes match, we immediately return the starting index of the substring. This method assumes no hash collisions, which is generally acceptable for LeetCode constraints.

The problem ran successfully on LeetCode.
"""
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        n_hash = 0
        for n in needle:
            n_hash = (n_hash* 26) + (ord(n))
        
        h_hash = 0
        kl = int(26(len(needle)-1))
        for i in range(len(haystack)):
            # out
            if i >= len(needle):
                out = i - len(needle)
                outChar = haystack[out]
                h_hash -= kl * (ord(outChar))

            # in
            inChar = haystack[i]
            h_hash = (h_hash*26) + (ord(inChar))

            #check
            if h_hash == n_hash:
                return i-len(needle)+1

        return -1