class Solution(object):
    # tc : O(n+m) n if the len of the needle and m is th elen of the haystack, O(n) to creatre needle hash, m to find the haystackhash equal to needle hash
    # sc : O(1)
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """

        # brute force , dubel for loop and check each character fo needle is matched in hasystakc if not then check from th4 next index in the haysstakc, tc O(m*n)
        # optimal : the issu in brute force is once we check a until the window of neelde and didn't find then we start checking again from the next ndex so basically in our firt window we check from 0-3 and next index 1-4 so we are comparinf 1,2 indexes again but comparing with different letter in needle
        # to avoid thsi complexity how about we maintain a hash value of needle and compare if that value is same as our inwdo in haystack
        # important : but we have to make a hash such that is it gives unique value for the arrangment of the letters, 2*12, 12*2 both gives sa,e but 2 is not 12 or 12 is not 2, to avoid collisions in the hash
        # lets multipy each character with base of 26 this will give us a unique representation(hashvalue) for the string, and to restore the intial letter when we are moving out of our sliding window, lets just subtract the earlier elements value in the hashwhich no longer belong to this window
        # once we foudn the perfect hash lets restun the prefix of window by current index - lenof needle +1 

        # hash of the needle
        needle_hash = 0
        n = len(needle)
        restore_hash = 26**n # when we will be reoving hash the first element will be of 26 power the len of needle so we will use it to remove that value from our hash)
        for char in needle:
            needle_hash = needle_hash*26 + ord(char) -ord('a') +1 # adding this 1 so that if our char is a then the value will be 0 and its like we never taken a into consideration so add 1 

        haystack_hash = 0
        for i in range(len(haystack)):
            char = haystack[i]
            haystack_hash = haystack_hash*26 + ord(char) -ord('a') +1

            if i >=n:
                restore_char = haystack[i-n] # we are moving out of the window lets remove the hash value of the earlier element which are no longer in our window
                haystack_hash -= restore_hash*(ord(restore_char) - ord('a') + 1)

            if haystack_hash == needle_hash:
                return i-n+1

        return -1 # if not present then fallback to -1




