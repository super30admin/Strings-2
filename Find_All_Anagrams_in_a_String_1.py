# Created by Aashish Adhikari at 11:40 PM 3/24/2021

# Please ignore this solution. Kept for personal reference only.
class Solution(object):

    def findAnagrams(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: List[int]
        """

        self.permutations_set = set()
        sol = []

        # generate all permutations
        # (using in-built functions are not encouraged, kept here oly for     reference, not as a               #  submitted solution)
        [self.permutations_set.add(''.join(p)) for p in permutations(p)]

        print("Permutations are ", self.permutations_set)

        for idx in range(0, len(s) - len(p)+1):

            if s[idx:idx+len(p)] in self.permutations_set:
                sol.append(idx)

        return sol




