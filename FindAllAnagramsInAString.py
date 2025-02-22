# Time Complexity : O(n) 
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA 

# Your code here along with comments explaining your approach:
# using sliding window approach
# using map to keep track of all characters in the string p and their frequencies/count
# anagrams have same characters with same frequency
# traversing over s making a window of len(p) and checking if the characters required (in p) are found in s (in current window)
# if the char is found, we reduce the required frequency by 1
# if the freq == 0, it means all freq of that character are found, thus increment match (the requirement for this character is fullfilled)
# however, when the length of the window > len(p), we have to let go of an element, and that becomes outgoing element
# we increase the freq of this character in map (because it's no longer part of our window)
# and if this freq changes from 0 to 1, it means this character is no longer matched
# thus we increment matched
# if matched == len(map), then all characters found, with required frequencies, we capture the start index of the window

class Solution(object):
    def findAnagrams(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: List[int]
        """

        if s is None or len(p) > len(s):
            return []
        
        # variables needed
        matched = 0
        # key is the character in p, and the frequency in that character
        hm = {}
        # result list
        result = []

        # building the map, by recording frequencies of all characters in p
        for i in range(len(p)):
            # resetting count at every character
            count = 1
            if p[i] in hm:
                # if character already exists
                # increment it's count's value by 1
                count = hm[p[i]] + 1
            # else we put the default value 1
            hm[p[i]] = count

        # traverse over the given string s
        for i in range(len(s)):
            # incoming character is the new character coming to the window
            incoming = s[i]
            if incoming in hm:
                # the character exists in the map
                # so we reduce the count of it's frequency in map
                hm[incoming] -= 1
                if hm[incoming] == 0:
                    # if the count of that character becomes 0
                    # so it means all fre of that character are matched
                    matched += 1
            
            # outgoing character - when i becomes => len(p)
            if i >= len(p):
                outgoing = s[i - len(p)]
                # if the outgoing character is present in map
                if outgoing in hm:
                    # so we have to increase it's value
                    hm[outgoing] += 1
                    # if the count has become 1 from 0
                    # it means it was matched earlier, now we need one more of this character
                    # for it to be matched again
                    if hm[outgoing] == 1:
                        matched -=1 
            
            if matched == len(hm):
                # extact characters are matched
                # handling repeatings also, because we are incrementing matched
                # only when the freq comes 0 in hm
                # so now we capture the starting index in result
                result.append(i - len(p) + 1)


        return result



        