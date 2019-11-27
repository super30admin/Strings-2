'''
Accepted on leetcode(28)
Using KMP Algorithm.(which is used to find the substring in main string)
First we design the KMP Algorithm for needle and apply the same technique to haystack and needke as well.

'''


class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        S = haystack
        P = needle
        N = len(haystack)
        M = len(needle)

        if M == 0: return 0

        KMP = self.KMPArray(P, M)  # get KMP Array
        # print(KMP)
        i = 0
        j = 0

        while i < N:
            if S[i] == P[j]:
                j += 1
                i += 1
            if j == M:
                return i - j
            elif i < N and S[i] != P[j] and j > 0:
                j = KMP[j - 1]
            elif i < N and S[i] != P[j] and j == 0:
                i += 1
        return -1

    def KMPArray(self, P, M):
        KMP = [0 for i in range(M)]

        i = 1
        j = 0

        while i < M:
            if P[i] == P[j]:
                j += 1
                KMP[i] = j
                i += 1
            elif P[i] != P[j] and j > 0:
                j = KMP[j - 1]
            elif P[i] != P[j] and j == 0:
                KMP[i] = j
                i += 1

        return KMP