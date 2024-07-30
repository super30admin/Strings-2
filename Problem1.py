#I implemented a method that scans through the haystack to find the first occurrence of the needle. I used two pointers to compare characters from both strings. If the characters match, I move both pointers forward. When a mismatch happens, I reset the needle pointer and shift the haystack pointer to the next starting position. This process continues until either a match is found or the end of haystack is reached. This approach has a time complexity of O(n⋅m) due to the nested comparisons, and a space complexity of O(1) since it only uses a few extra variables.

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if needle not in haystack:
            return -1
        else:
            k=0
            i=0
            j=0
            while j<len(needle) and i<len(haystack):
                if needle[j]!=haystack[i]:
                    i=i-j+1
                    j=k
                else:
                    i+=1
                    j+=1
            return i-j
            


        