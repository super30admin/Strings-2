"""
28. Implement strStr()
Time Complexity - O(n+m) length of largest of the two strings
Space Complexity - O(m) m is length of needle"""
class Solution:
    #With help of Longest Prefix Suffix Algorithm we are implementing comparision between haystack and needle and when we find that there is a match then we return index else with help of lps array we are comparing and if not found referring lps array to get the solution
    def strStr(self, haystack: str, needle: str) -> int:
        if needle == None or len(needle) == 0:
            return 0
        lps = self.lps(needle)
        i = 0 
        j = 0
        while(i < len(haystack)):
            if haystack[i] == needle[j]:
                i += 1
                j += 1
                if j >= len(needle):
                    return i-j
            elif( j != 0 and haystack[i] != needle[j]):
                j = lps[j-1]
            elif( j == 0 and haystack[i] != needle[j]):
                i += 1
        return -1
    #LPS helps us in creating a list that stores length of prefrix and suffix that match and we store length of matching string
    def lps(self, needle):
        lps = [0]*len(needle)
        i = 1
        j = 0
        while(i < len(needle)):
            if needle[i] == needle[j]:
                j += 1
                lps[i] = j                
                i += 1
            elif( j != 0 and needle[i] != needle[j]):
                j = lps[j-1]
            elif( j == 0 and needle[i] != needle[j]):
                lps[i] = 0
                i += 1
        return lps
                