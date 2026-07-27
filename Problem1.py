# Problem1:Implement strStr() (https://leetcode.com/problems/implement-strstr/)
# Time complexity is O(m + n),here m is the length of haystack and n is the length of needle building the lps array takes O(n) time scanning the haystack takes O(m) time because the i pointer never moves backward so the total work added together is O(m + n)
# Space complexity is O(n),this is because we create an lps array that is the same length as the needle, we do not use any other extra space that grows with input size
# Approach:
# First we build a helper array called lps for the needle.lps tells us, for every position in needle, the length of the longest proper prefix that is also a suffix at that position
# This helps us later because when we find a mismatch while scanning haystack,we do not need to go back and recheck characters in haystack that we already matched instead we use lps to know exactly where to continue checking from in the needle
# This way the haystack pointer i only moves forward and never wastes workclass Solution:
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:   
        self.n = len(needle)        # store the length of needle so we can use it easily later

        # create an empty lps array of the same size as needle, filled with zeros for now
        self.lps = [0] * self.n
        self.preprocess(needle)     # call the helper function that will fill up the lps array properly
       
        i = 0        # i is our pointer that moves through haystack
        j = 0            # j is our pointer that moves through needle

        # keep going until we reach the end of haystack
        while i < len(haystack):
            # if the current characters in haystack and needle match
            if haystack[i] == needle[j]:
                # move both pointers forward since this character matched
                i += 1
                j += 1

                # if j reached the end of needle, that means we matched the whole needle
                if j == self.n:
                    # return the starting index of the match
                    # this is current i minus the length of needle j
                    return i - j

            # if characters do not match, but we already had some partial match going on
            elif haystack[i] != needle[j] and j > 0:
                # instead of starting over, we jump j back using the lps array
                # this tells us the next best position to continue comparing from
                # notice that i does not move here, we are not rechecking haystack
                j = self.lps[j - 1]

            # if characters do not match and we have no partial match to fall back on
            else:
                # there is nothing to reuse, so we simply move i forward to try fresh
                i += 1

        # if we finish scanning the whole haystack and never returned
        # that means needle was never found inside haystack
        return -1

    def preprocess(self, needle: str):
        # the first position of lps is always 0
        # because a single character alone cannot have a proper prefix that is also a suffix
        self.lps[0] = 0

        # i starts at 1 because we already filled index 0
        i = 1

        # j represents the length of the current matching prefix we are tracking
        j = 0

        # keep going until we have checked every character of needle
        while i < self.n:
            # if the character at position i matches the character at position j
            if needle[i] == needle[j]:
                # our matching prefix grows longer by one
                j += 1

                # store this new length into lps at position i
                self.lps[i] = j

                # move to the next character to check
                i += 1

            # if characters do not match, but j is greater than 0
            # that means we were tracking some partial match before this
            elif needle[i] != needle[j] and j > 0:
                # fall back to a shorter previous match using lps
                # we try comparing again using this new smaller j
                # notice i does not move here
                j = self.lps[j - 1]

            # if characters do not match and j is already 0
            else:
                # there is no shorter match to fall back on
                # so this position has no matching prefix at all
                self.lps[i] = 0

                # move forward to check the next character
                i += 1
