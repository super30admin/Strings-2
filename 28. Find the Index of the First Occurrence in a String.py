##28. Find the Index of the First Occurrence in a String########################################################################################
// Time Complexity : m+n -> length or substrate + length of string
// Space Complexity : O(1) -> no extra space just calculation for rolling hash
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no problem

// Your code here along with comments explaining your approach in three sentences only
Here we used rolling has to identify the substring value and than we used sliding window to find rolling hash value for each substring with the length equal to matching string, while moving I made sure to remove previous element by taking mod with 10^len(matchstring-1) 


class Solution:
    
    def ascii2int(self,c) ->int:
        return ord(c)-ord('a')+1

    def strStr(self, haystack: str, needle: str) -> int:
        needleint=0
        haystackint=0
        lenchk=len(needle)
        for i in needle:
            print(self.ascii2int(i))
            needleint=needleint*100+self.ascii2int(i)
        print(needleint)
        for i,val in enumerate(haystack):
            if i<lenchk:
                haystackint=haystackint*100+self.ascii2int(val)
            else:
                haystackint=haystackint%pow(100,lenchk-1)
                haystackint=haystackint*100+self.ascii2int(val)
            if haystackint==needleint:
                return i-lenchk+1
        return -1

        
        
