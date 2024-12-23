class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:

        # time complexity: O(m+n)

        result = []
        window_count = {}
        p_count = {}

        len_p = len(p)
        len_s = len(s)

        for char in p:
            if char in p_count:
                p_count[char] += 1
            else:
                p_count[char] = 1
        for char in s[:len_p]:
            if char in window_count:
                window_count[char] += 1
            else:
                window_count[char] = 1

        if window_count == p_count:
            result.append(0)

        for i in range(len_p, len_s):
            right_char = s[i]

            if right_char in window_count:
                window_count[right_char] += 1
            else:
                window_count[right_char] = 1
            left_char = s[i - len_p]
            window_count[left_char] -= 1

            if window_count[left_char] == 0:
                del window_count[left_char]
            if window_count == p_count:
                result.append(i - len_p + 1)
        return result


# time complexity is O(n) where n is length of s since we slide through the s once
# space complexity is O(n)
