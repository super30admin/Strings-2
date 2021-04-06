# Created by Aashish Adhikari at 12:13 AM 3/25/2021

'''
Time Complexity:
O(n)

Space Complexity:
O(1)
'''

class Solution(object):

    def findAnagrams(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: List[int]
        """

        sol = []

        hm = {}

        # store characters in p and the counts into a hashmap
        for c in range(len(p)):
            if p[c] not in hm:
                hm[p[c]] = 1
            else:
                hm[p[c]] += 1

        total_match_in_current_window = 0

        for i in range(0, len(s)):

            # incoming character
            incoming = s[i]

            if incoming in hm:
                cnt = hm[incoming]
                cnt -= 1


                if cnt == 0:
                    total_match_in_current_window += 1
                hm[incoming] = cnt



            # outgoing character
            if i >= len(p):

                outgoing = s[i - len(p)]

                if outgoing in hm:
                    cnt = hm[outgoing]
                    cnt += 1

                    if cnt == 1:
                        total_match_in_current_window -= 1
                    hm[outgoing] = cnt

            # check if anagram matches
            if total_match_in_current_window == len(hm):
                sol.append(i - len(p) + 1)


        return sol











