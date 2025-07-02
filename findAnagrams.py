"""
Count characters in p using frequency map
Slide a window of size len(p) over s and maintain its frequency count
If the window count matches p's count, record starting index
"""
"""
Time Complexity: O(n) - Pass through string
Space Complexity: O(1) (since only 26 lowercase letters)
"""


from collections import Counter

class findAnagram:
    def findAllAnagrams(self, s: str, p: str) -> list[int]:
        len_p = len(p)
        len_s = len(s)
        result = []

        if len_s < len_p:
            return result

        p_count = Counter(p)
        window_count = Counter(s[:len_p - 1])

        for i in range(len_p - 1, len_s):
            window_count[s[i]] += 1

            if window_count == p_count:
                result.append(i - len_p + 1)

            window_count[s[i - len_p + 1]] -= 1
            if window_count[s[i - len_p + 1]] == 0:
                del window_count[s[i - len_p + 1]]

        return result

if __name__ == "__main__":
    obj = findAnagram()
    print(obj.findAllAnagrams("cbaebabacd", "abc"))
    print(obj.findAllAnagrams("abab", "ab"))  
