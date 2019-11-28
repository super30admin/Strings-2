#Accepted on leetcode
#Time complexity - O(NM)) where N is len of haystack and M i slen of needle
#Space omplexity - O(M) we use KMP array of size M

class Solution(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        #Initialization
        S = haystack
        N = len(S)
        P = needle
        M = len(P)
        
        #Edge case
        if M==0:
            return 0
        
        KMP = self.KMPArray(P,M)
        i = 0
        j = 0
        while i<N:
            if S[i] == P[j]:
                j += 1
                i += 1
            if j==M:
                return i-j
            elif (i<N and S[i]!=P[j] and j>0):
                j = KMP[j-1]
            elif (i<N and S[i]!=P[j] and j==0):
                i += 1
        return -1
       
    
    def KMPArray(self,P,M):
        KMP = [0 for k in range(M)]
        i = 1
        j = 0
        while i<M:
            #Case1: When both the chars are same
            if P[i] == P[j]:
                j += 1
                KMP[i] = j
                i += 1
            #Case2: When both chars are not equal and j > 0 (not in 0th index)
            elif P[i] != P[j] and j > 0:
                j = KMP[j-1]
            #Case3: When both chars are not equal and j is at 0th index
            elif P[i] != P[j] and j == 0:
                KMP[i] = j
                i += 1
        return KMP