#Time Complexity: O((N - M + 1) * M), where N = len(haystack), M = len(needle)
# Space Complexity: O(1)

def strstr(haystack: str, needle: str) -> int:
    if not needle:
        return 0
    n, m = len(haystack), len(needle)
    for i in range(n - m + 1):
        if haystack[i:i + m] == needle:
            return i
    return -1