class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:

        if len(p) > len(s):
            return []

        p_count = Counter(p)
        match = 0
        res = []
        required = len(p_count)

        # Initialize window
        for i in range(len(p)):
            char = s[i]
            if char in p_count:
                p_count[char] -= 1
                if p_count[char] == 0:
                    match += 1

        if match == required:
            res.append(0)

        # Slide window
        for i in range(len(p), len(s)):
            in_char = s[i]
            out_char = s[i - len(p)]

            # In char
            if in_char in p_count:
                p_count[in_char] -= 1
                if p_count[in_char] == 0:
                    match += 1

            # Out char
            if out_char in p_count:
                if p_count[out_char] == 0:
                    match -= 1
                p_count[out_char] += 1

            if match == required:
                res.append(i - len(p) + 1)

        return res