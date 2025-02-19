class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        # T: O(n), S: O(1)
        if len(p) > len(s):
            return []

        p_count = Counter(p)  # Frequency count of p
        s_count = Counter(
            s[: len(p) - 1]
        )  # Frequency count of the first (window - 1) chars in s
        result = []

        for i in range(len(p) - 1, len(s)):  # Start checking from window end
            # Add the new character to the window
            s_count[s[i]] += 1

            # If window matches, add the start index
            if s_count == p_count:
                result.append(i - len(p) + 1)

            # Remove the leftmost character to slide the window
            left_char = s[i - len(p) + 1]
            s_count[left_char] -= 1
            if s_count[left_char] == 0:
                del s_count[left_char]  # Remove key to keep dict size minimal

        return result
