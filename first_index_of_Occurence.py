# -------------------------------
# Approach 1: Brute Force
# -------------------------------
# 1. Iterate over each possible starting position in `haystack` from 0 to n - m
# 2. Check substring haystack[i:i+m] with needle
# 3. If equal, return index
#
# Time Complexity: O(n * m)
# Space Complexity: O(1)

# -------------------------------
# Approach 2: KMP (Knuth-Morris-Pratt) Algorithm
# -------------------------------
# 1. Build the LPS (Longest Prefix Suffix) array for `needle`.
#    - lps[i] stores the length of the longest prefix which is also suffix for needle[0...i]
# 2. Use LPS to perform pattern matching:
#    - If match continues, move both pointers.
#    - On mismatch, use LPS to skip unnecessary comparisons.
#
# Time Complexity:
# - LPS Construction: O(m)
# - Search: O(n)
# - Total: O(n + m)
#
# Space Complexity: O(m) for LPS array

class Solution:
    def strStr_bruteForce(self, haystack, needle):
        n, m = len(haystack), len(needle)

        for i in range(n - m + 1):
            if haystack[i:i+m] == needle:
                return i
        return -1
    
    def strStr_kmp(self, haystack, needle):
        if not needle:
            return 0
        
        # Build LPS array
        lps = [0] * len(needle)
        length = 0
        i = 1
        while i < len(needle):
            if needle[i] == needle[length]:
                length += 1
                lps[i] = length
                i += 1
            else:
                if length != 0:
                    length = lps[length - 1]
                else:
                    lps[i] = 0
                    i += 1
        print(lps)
        # KMP search
        i = j = 0
        while i < len(haystack):
            if haystack[i] == needle[j]:
                i += 1
                j += 1
                if j == len(needle):
                    return i - j
            else:
                if j != 0:
                    j = lps[j - 1]
                else:
                    i += 1

        return -1

# Main function to test both approaches
def main():
    sol = Solution()

    print("Test Case 1:")
    haystack = "hello"
    needle = "ll"
    print("BruteForce:", sol.strStr_bruteForce(haystack, needle))  # Expected: 2
    print("KMP:", sol.strStr_kmp(haystack, needle))                # Expected: 2

    print("\nTest Case 2:")
    haystack = "aaaaa"
    needle = "bba"
    print("BruteForce:", sol.strStr_bruteForce(haystack, needle))  # Expected: -1
    print("KMP:", sol.strStr_kmp(haystack, needle))                # Expected: -1

    print("\nTest Case 3:")
    haystack = "mississippi"
    needle = "issip"
    print("BruteForce:", sol.strStr_bruteForce(haystack, needle))  # Expected: 4
    print("KMP:", sol.strStr_kmp(haystack, needle))                # Expected: 4

    print("\nTest Case 4 (Empty Needle):")
    haystack = "abc"
    needle = ""
    print("BruteForce:", sol.strStr_bruteForce(haystack, needle))  # Expected: 0
    print("KMP:", sol.strStr_kmp(haystack, needle))                # Expected: 0

    print("\nTest Case 5:")
    haystack = "abcabcabcd"
    needle = "abcd"
    print("BruteForce:", sol.strStr_bruteForce(haystack, needle))  # Expected: 6
    print("KMP:", sol.strStr_kmp(haystack, needle))                # Expected: 6

if __name__ == "__main__":
    main()