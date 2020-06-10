#Time Complexity:O(log n)
#Space complexity:O(1)
#Ran successfully on leetcode:yes
#Algorithm:
#1.Sort p string. 
#2.FInd using sliding window of the length of p string, if p exists as a substring in in the sorted window of s string.
#3. Append the index it occured to result.
#4. return result
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        result = []
        sort_p=''.join(sorted(p))
        for i in range(len(s)-len(p)+1):
            if ''.join(sorted(s[i:i+len(p)]))== sort_p:
                 result.append(i)
        return result
