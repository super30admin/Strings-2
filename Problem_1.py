"""
Problem : 1

Time Complexity : 
Bruteforce - O(m*n)
Sliding Window - O(n)

Space Complexity : O(1)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Bruteforce - 
Iterating over the haystack, and finding the character which matches the first character in needle
if found, checking the next m characters in the haystack, if they match needle, if matched, returning the index from where we started
else moving ahead in the haystack, if no needle found in haystack, returning -1


Sliding window - 
Assigning each character a unique number, to store and identify the actual order of the needle in haystack
adding the character in the window until the window size matches size of needle, and calculating the unique addition for all the
character in the window in the order they are added, removing the character at the start of the window and updating the addition,
and adding the next character in the window and updating the addition, if the addition matches that of needle, returning the index
where the window starts, if no needle found, returning -1 in the end

"""

# Implement strStr()


# Approach - 1
# Bruteforce

class Solution(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        m=len(haystack)
        n=len(needle)
        if m<n:
            return -1
        i=0
        while i<=m-n:
            if haystack[i]==needle[0]:
                k=i
                j=0
                while haystack[k]==needle[j]:
                    k+=1
                    j+=1
                    if j==n:
                        return i
            i+=1  


        
        return -1

# Approach - 2
# Sliding Window
class Solution(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        hmap=[i+1 for i in range(26)]
        nres=0
        for i in range(len(needle)):
            nres=nres*2+hmap[ord(needle[i])-ord('a')]

        start=0
        end=0
        hres=0
        while end<len(haystack):
            hres=hres*2+hmap[ord(haystack[end])-ord('a')]
            
            if end>=len(needle):
                hres=hres-hmap[ord(haystack[start])-ord('a')]*pow(2,len(needle))
                start+=1


            end+=1

            if hres==nres:
                return start
                

        return -1