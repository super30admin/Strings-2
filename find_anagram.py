# Time Complexity: O(m + n)
# Space Complexity: O(1)

from collections import defaultdict


class Solution:
    #     Maintaining the hashmap for saving second string
    def findAnagrams(self, s, p):
        result = []
        hmap = defaultdict()
        match = 0
        #         iterate over the 2nd string and update the count
        for i in range(len(p)):
            if p[i] in hmap:
                hmap[p[i]] += 1
            else:
                hmap[p[i]] = 1

        # Then we will iterate over the 1 st string and decrease the count and
        # count ==0 then we will update the match variable by 1
        # We will check edge case and check if current index - len of 2 nd string is in
        # map then we will increase its count and if count is == 1 then we will decrease out match variable
        # or we can say we are discarding that pattern
        # In the end if the length of map and match count equals then we will append the index to the result
        # and will continue
        for i in range(len(s)):

            if s[i] in hmap:
                hmap[s[i]] -= 1

                if hmap[s[i]] == 0:
                    match += 1

            if i >= len(p) and s[i - len(p)] in hmap:
                hmap[s[i - len(p)]] += 1

                if hmap[s[i - len(p)]] == 1:
                    match -= 1

            if match == len(hmap):
                result.append(i - len(p) + 1)

        return result



