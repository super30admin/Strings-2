# leetode 28
#bruteforce --  check each element in pattern with j pointer and i pointer (keep incrementing till there is a match)and in if i and j does not match bring the j pointer in pattern to befinning and the i pointer to 2nd element in super string and keep repeating he same
#optimal klm -- time
#space

#find the klm array:
#algo : with this we are finding prefixes and sufixes,
# number the patterrn array and ge the klu algo
#by default all the klm array elements are initiated to 0 and then the elements are brought numberes according to the matching elemenets

class Solution:
    def strStr(self, haystack, needle):
        Superstring = haystack
        pattern = needle
        if len(pattern) == 0:
            return 0
        kmp = self.Kmp_helper(pattern)
        print(kmp)
        i = 0
        j = 0
        while i < len(Superstring):
            if Superstring[i] == pattern[j]:
                j += 1
                i += 1
            if j == len(pattern):
                return i - j  # pattern matched and retirung staring point of pattern
            elif i < len(Superstring) and Superstring[i] != pattern[j] and j > 0:  # check for previous patterns
                j = kmp[j - 1]  # point where the prefixes match
            elif i < len(Superstring) and Superstring[i] != pattern[j] and j == 0: #if else case is not given then pattern equal case comes here
                i += 1
        return -1  # case when end of pattern is not reached

    def Kmp_helper(self, pattern):
        # initialising variables
        kmp = [0 for i in range(len(pattern))]
        j = 0
        i = 1
        # algo
        while i < len(pattern):  #
            if pattern[i] == pattern[j]:
                j += 1
                kmp[i] = j
                i += 1
            elif pattern[i] != pattern[j] and j > 0:
                j = kmp[j - 1]  # go to the previous elemt
            else:  # case when Pattern[i] != Pattern[j] and j == 0
                kmp[i] = j
                i += 1
        return kmp
