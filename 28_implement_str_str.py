class Solution:
    def strStrBruteForce1(self, haystack: str, needle: str) -> int:
        """
            https://leetcode.com/problems/implement-strstr/
            Time Complexity - O(n*m)
                'n' is the length of haystack
                'm' is the length of the needle
            Space Complexity - O(1)
            Explanation -
                - Make substrings of size needle in the haystack and compare
                  if it matches with the needle.
        """
        if len(haystack) < len(needle):
            return -1
        if len(needle) == 0:
            return 0

        for i in range(len(haystack)):
            if haystack[i:i + len(needle)] == needle:
                return i
        return -1

    def strStrBruteForce2(self, haystack: str, needle: str) -> int:
        """
            https://leetcode.com/problems/implement-strstr/
            Time Complexity - O(n*m)
                'n' is the length of haystack
                'm' is the length of the needle
            Space Complexity - O(1)
            Explanation -
                - Slow pointer -> moves on the haystack
                - Fast pointer -> moves on the needle
                - slow - fast (distance travelled by slow pointer)
                  used to reset to the prev start position
        """
        if len(haystack) < len(needle):
            return -1
        if not needle:
            return 0

        slow = fast = 0
        while fast < len(needle) and slow < len(haystack):
            if haystack[slow] != needle[fast]:
                slow = slow - fast + 1
                fast = 0
                continue
            slow += 1
            fast += 1
        return slow - fast if fast == len(needle) else -1

    def _build_lps(self, pattern: str) -> list:
        """
            Helper method for strStr.
            Returns longest proper suffix array for string pattern.
            Each lps_array[i] is the length of the longest proper prefix
            which is equal to suffix for pattern ending at character i.
            Proper means that whole string cannot be prefix or suffix.

            Time complexity: O(m)
            Space complexity: O(1)
            m is the length of the pattern, space used for lps array isn't included.
        """
        m = len(pattern)
        lps_array = [0] * m
        i, j = 1, 0  # start from the 2nd character in pattern
        while i < m:
            if pattern[i] == pattern[j]:
                lps_array[i] = j + 1
                j += 1
                i += 1
            else:
                if j > 0:
                    j = lps_array[j - 1]
                else:
                    lps_array[i] = 0
                    i += 1
        return lps_array

    def strStr(self, haystack: str, needle: str) -> int:

        """
            Returns index of 1st occurence of pattern in text.
            Returns -1 if pattern is not in the text.
            Knuth–Morris–Pratt algorithm.
            Time complexity: O(n + m)
            Space complexity: O(m)
        """
        # edge cases
        if len(haystack) < len(needle):
            return -1
        if len(needle) == 0:
            return 0

        # build longest proper suffix array for pattern
        lps_array = self._build_lps(needle)

        h, n = len(haystack), len(needle)
        i, j = 0, 0
        while i < h:
            # current characters match, move to the next characters
            if haystack[i] == needle[j]:
                i += 1
                j += 1
            # current characters don't match
            else:
                if j > 0:  # try start with previous longest prefix
                    j = lps_array[j - 1]
                # 1st character of pattern doesn't match character in text
                # go to the next character in text
                else:
                    i += 1

            # whole pattern matches text, match is found
            if j == n:
                return i - n

        # no match was found
        return -1


if __name__ == '__main__':
    Solution().strStrBruteForce2('hello', 'll')
    Solution().strStrBruteForce2('aaaaab', 'aaab')
