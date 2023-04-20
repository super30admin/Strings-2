class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        # Approach 1 Comparing strings directly
        # Time Complexity: O(n * m)
        # Space Complexity: O(m)
        # hset = set()
        # hset.add(needle)
        # p1 = 0
        # for p2 in range(len(haystack)):
        #     if (p2 - p1) < len(needle)-1:
        #         p2 += 1
        #     else:
        #         if haystack[p1:p2+1] in hset:
        #             return p1

        #         p1 += 1
        # return -1

        # Approach 2 Uisng Rabin-Karp Algorithm
        # Time Complexity: O(n)
        # Space Complexity: O(1)

        # Create a hash value for needle
        h_needle = 0
        for i in needle:
            h_needle = h_needle * 26 + (ord(i) - 96)
        # print(h_needle)

        # Create a running hash value for haystack
        p1 = 0
        currhash = 0
        power = pow(26, len(needle))

        for p2 in range(len(haystack)):
            if (p2 - p1) < len(needle):
                currhash = currhash * 26 + (ord(haystack[p2]) - 96)
            else:
                # print(p2)
                # print("here", currhash)
                if h_needle == currhash:
                    return p1

                # print(haystack[p2], (ord(haystack[p2]) - 96))
                currhash = currhash * 26 + (ord(haystack[p2]) - 96)
                # print(currhash)
                currhash = currhash % ((ord(haystack[p1]) - 96) * power)
                # print(currhash)
                p1 += 1

        # print(currhash, h_needle)
        if currhash == h_needle:
            return p1

        return -1



