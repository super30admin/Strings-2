"""
In programming languages, it is substring, and it will return the first index of occurrence
Approach1: traverses both middle and haystack, for each character in haystack check if can form niddle.
TC: O(m*n)*n
Approach2:find all substrings and check if same substring
TC: O(m*n)
Approach3: for the pattern finding there are 2 ways: rolling hash and KMP.
Rolling hash:
the prime products of two anagrams are same. But rolling hash will give separate value for different anagrams.
Assume each ch have some value: {"a":1, "b": 2, "c": 3, "d": 4, .....} Now find the rolling hash on the pattern (abac).
Initially, hash value = 0, for a: hash value = hash value * total_number of ch in hmap (26) + value of ch (1) = 0 * 26+1
= 1. Then go to next ch-> hash value = hash value (1) * total_number of ch in hmap (26) + value of ch (2) = 28
The contribution of "a" in hash value = 1*26, The contribution of curr ch "b" in hash value is 2.
Then go to next ch-> hash value = hash value (28) * total_number of ch in hmap (26) + value of ch (1) = 729
The contribution of "a" in hash value = 1*26, The contribution of "b" in hash value is 2 * 26.
The contribution of curr ch "a" in hash value is 1. We have 2 "a" but each a have different contribuiton because of 
its location.
When checking the pattern, the anagram whose value rolling hash is equal to pattern's rolling hash is the answer.
We can not use prime product here to match a pattern with the string since  the anagram of pattern will have
same prime product.
"""


class Solution_rolling_hash:
    def strStr(self, haystack: str, needle: str) -> int:

        # calculate rolling hash of pattern
        n_hash = 0
        num_ch = 26
        for ch in needle:
            # rolling hash = current hash * num of charcater + ASSIC value of ch
            n_hash = n_hash * num_ch + (ord(ch) - ord("a") + 1)
        print(n_hash)

        h_hash = 0
        ans = -1
        contri = pow(num_ch, len(needle))
        for idx in range(len(haystack)):
            # for the incoming ch
            in_ch = haystack[idx]
            h_hash = h_hash * num_ch + (ord(in_ch) - ord("a") + 1)

            # check if there is out going ch
            if idx >= len(needle):
                # get out ch
                out_idx = idx - len(needle)
                out_ch = haystack[out_idx]
                # remove the contribution of outgoing ch charcater
                # substract the current hash from the
                h_hash = h_hash - contri * (ord(out_ch) - ord("a") + 1)

            if h_hash == n_hash:
                ans = idx - len(needle) + 1
                break

        print(h_hash)
        return ans


class Solution_brute_force:
    def strStr(self, haystack: str, needle: str) -> int:
        needle_idx = 0
        ans = -1
        for i in range(len(haystack)):
            needle_idx = 0
            for j in range(i, len(haystack)):
                if needle_idx < len(needle) and haystack[j] == needle[needle_idx]:
                    needle_idx += 1
                else:
                    break

            if needle_idx == len(needle):
                ans = i
                return ans

        return ans
