# Created by Aashish Adhikari at 5:20 PM 3/18/2021

'''
Time Complexity:
O(m+n)

Space Complexity:
O(m)
'''

class Solution(object):


    def longest_common_prefix_array(self, needle):
        '''
        USES KMP algorithm

        Generates an array, which for each index i in needle, contains the length of the longest common prefix-suffix   of the string needle[0:i+1]

        This can be generated using BRUTEFORCE in O(n ^2) but can be done in O(n) as shown here using sliding window.
        '''

        lps = [0 for idx in range(0, len(needle))]
        j = 0 # will represents the ending point of the prefix
        i = 1 # will represents the ending point of the suffix



        while i <len(needle):

            if needle[i] == needle[j]:
                j += 1
                lps[i] = j # as j represents the length of the prefix from index 0 to position j
                i += 1
            elif needle[i] != needle[j] and j > 0:
                # decrease j
                j = lps[j-1] # resets the position of j to an index where there is a possibility of prefix-suffix match
                # Now, in the next iteration of the while loop, we will see if there is a match
                # If there is, fill lps[i] else repeat until either matches or reaches left end.
            else:
                # needle[i] != needle[j] and j == 0
                lps[i] = 0
                i += 1

        return lps


    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """

        m, n = len(haystack), len(needle)

        if n== 0:
            return 0
        # create the lps array of the needle which can be used below to reset j when necessary
        lps = self.longest_common_prefix_array(needle)


        i = 0 # index in haystack
        j = 0 # index in needle

        while i < m:

            if haystack[i] == needle[j]:

                i += 1
                j += 1

                if j == n:

                    return i - len(needle) # initial index in the haystack
            elif haystack[i] != needle[j] and j > 0:

                j = lps[j-1]
            else:
                # haystack[i] != needle[j] and j == 0
                i += 1


        return -1
