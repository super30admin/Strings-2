class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        len_h = len(haystack)
        len_n = len(needle)

        if len_n == 0:
            return 0
        if len_n > len_h:
            return -1

        base = 26
        mod = 2**31 - 1

        needle_hash = 0
        window_hash = 0
        for i in range(len_n):
            needle_hash = (needle_hash * 26 + ord(needle[i])) % mod
            window_hash = (window_hash * 26 + ord(haystack[i])) % mod

        high_order_base = pow(base, len_n - 1, mod)

        for i in range(len_h - len_n + 1):
            if needle_hash == window_hash:
                if haystack[i : i + len_n] == needle:
                    return i

            if i + len_n < len_h:
                window_hash = (
                    (window_hash - ord(haystack[i]) * high_order_base) * base
                    + ord(haystack[i + len_n])
                ) % mod
                if window_hash < 0:
                    window_hash += mod
        return -1


# time complexity is O(len_h+len_n)
# space complexity is O(n)
