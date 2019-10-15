"""
Iterate over the haystack string and the place where i to i+ len(needle) is equal to needle is the answer.
Time complexity - O(N)
Space complexity - O(1)
Leetcode - running


"""
def strStr(self, haystack, needle):
        N = len(haystack) - len(needle) + 1
        for i in range(0,N):
            if haystack[i:i+len(needle)] == needle:
                return i
        return -1