// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
we create two lists of length 26 for the string p and string q.for pattern p we take the count of each character in a list and we take two pointers start and end and by adjusting both these two pointers in string p we see if both the created lists are same or not.If yes then we store the value of start.

# Time complexity --> o(m+n) m =len(s) and n=len(p)
# space complexity --> o(1)
class Solution(object):
    def findAnagrams(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: List[int]
        """
        if len(s)<len(p):
            return []
        result=[]
        listp=[0 for i in range(26)]
        lists=[0 for i in range(26)]
        for i in p:
            listp[ord(i)-ord('a')]=listp[ord(i)-ord('a')]+1
        start=0
        end=0
        while end<len(s):
            lists[ord(s[end])-ord('a')]=lists[ord(s[end])-ord('a')]+1
            if end-start+1>len(p):
                lists[ord(s[start])-ord('a')]=lists[ord(s[start])-ord('a')]-1
                start=start+1
            if lists==listp:
                result.append(start)
            # print(lists)
            # print(listp)
            end=end+1
        return result
                
            
            
            
            
        