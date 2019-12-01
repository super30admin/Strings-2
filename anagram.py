# time complexity: o(m)
# space complexity: O(1)
# leetcode:accepted
# explaination: 1. create a hashmap with all the characters in the pattern.
# traverse the actuall s, with a sliding window of size equal to the lenght of the pattern. For any incoming character, decrease the value in the hashmap. for any character that is going out from the sliding window, and if that character is there in the hashmap, increase the value. in hashmpap, if the value of ay character goes to 0, it means match has been found. Increase the match. If the value goes from zero to one, then decrease the match. Likewise, if the match becomes equal to the lenght of the d1, return the index-sizeof(P)


class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:

        # edge cases
        if s == None or p == None or len(s) == 0 or len(p) == 0:
            return None

        # initialise all variables

        d1 = dict()
        result = []
        match = 0

        # initialising the hashmap for characters in pattern
        for c in p:
            if c not in d1:
                d1[c] = 1
            else:
                d1[c] += 1

        # traversing the string to check for match:
        for i in range(len(s)):
            if s[i] in d1.keys():
                d1[s[i]] -= 1
                if d1[s[i]] == 0:
                    match += 1

            # sliding window of size p

            if i >= len(p):

                # checking outgoing string
                if s[i - len(p)] in d1.keys():
                    d1[s[i - len(p)]] += 1
                    if d1[s[i - len(p)]] == 1:
                        match -= 1

            if match == len(d1):
                result.append(i - len(p) + 1)

        return result




