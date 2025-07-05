# Approach 1: Brute Force
# -------------------------------
# 1. Iterate over all substrings of length len(p) in `s`
# 2. For each substring, compare its character count (Counter) with Counter(p)
#
# Time Complexity: O(n * k), where n = len(s), k = len(p)
# Space Complexity: O(k) for each Counter

# -------------------------------
# Approach 2: Optimized Sliding Window
# -------------------------------
# 1. Use a sliding window of size len(p)
# 2. Maintain character count for the window and update it as the window moves
# 3. Compare with Counter(p) at each step
#
# Time Complexity: O(n + k)
# Space Complexity: O(k) for character counters


from collections import Counter
class Solution:
    def findAnagrams_bruteForce(self, s, p):
        if not p or len(p) > len(s):
            return []
        i = j = 0
        hashmap_p = Counter(p)
        res = []
        while i < len(s) and j < len(s):
            j = i + len(p) - 1
            subStr = Counter(s[i:j + 1])
            if hashmap_p == subStr:
                res.append(i)
            i += 1
        return res
    
    def findAnagrams_slidingWindow(self, s, p):
        if not p or len(p) > len(s):
            return []

        res = []
        p_count = Counter(p)
        window = Counter(s[:len(p)])  # First window

        if window == p_count:
            res.append(0)

        for i in range(len(p), len(s)):
            start_char = s[i - len(p)]
            end_char = s[i]

            window[end_char] += 1
            window[start_char] -= 1

            if window[start_char] == 0:
                del window[start_char]

            if window == p_count:
                res.append(i - len(p) + 1)

        return res


def main():
    sol = Solution()

    print("Test Case 1:")
    s = "cbaebabacd"
    p = "abc"
    print("Brute Force:", sol.findAnagrams_bruteForce(s, p))         # Expected: [0, 6]
    print("Sliding Window:", sol.findAnagrams_slidingWindow(s, p))   # Expected: [0, 6]

    print("\nTest Case 2:")
    s = "abab"
    p = "ab"
    print("Brute Force:", sol.findAnagrams_bruteForce(s, p))         # Expected: [0, 1, 2]
    print("Sliding Window:", sol.findAnagrams_slidingWindow(s, p))   # Expected: [0, 1, 2]

    print("\nTest Case 3 (No matches):")
    s = "abcdef"
    p = "gh"
    print("Brute Force:", sol.findAnagrams_bruteForce(s, p))         # Expected: []
    print("Sliding Window:", sol.findAnagrams_slidingWindow(s, p))   # Expected: []

    print("\nTest Case 4 (Edge Case: Empty p):")
    s = "abc"
    p = ""
    print("Brute Force:", sol.findAnagrams_bruteForce(s, p))         # Expected: []
    print("Sliding Window:", sol.findAnagrams_slidingWindow(s, p))   # Expected: []

if __name__ == "__main__":
    main()