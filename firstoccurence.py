# TC : O(n), SC: O(1)
# If haystack is needle retuen 0
# We loop through haystack and check if current hay is needle
# If not, we remove zeroth element from the begining and add one from right to our window - hay[1:n] + haystack[i]
# if no match is found return -1


def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        if not needle:
            return 0
        if haystack == needle:
            return 0
        
        n = len(needle)
        h = len(haystack)

        #keep the window of n elements from haystack
        hay = haystack[0:n]

        #start the loop from length of needle to length of haystack
        for i in range(n, h+1):
            if hay == needle:
                return i - n # we are return the first occurence
            if i<h: 
                hay = hay[1:] + haystack[i]

        return -1