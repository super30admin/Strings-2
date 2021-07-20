"""
Approach Brute Force: 3 ptr solution
ptr 1 is i , at haystack string, to maintain original str
ptr 2 is j , at needle , will start when 1st char of haystack matches with 1st char at needle
ptr 3 is k, will start from i , when 1st char of both str are equal
While boundries, keep incrementing k and j
"""
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        m=len(haystack)
        n=len(needle)

        if needle==0 or n==0: #if len of second string is zero, nothing to iterate over/find
            return 0

        i=0 #haystack  ptr
        #j=0 #needle ptr

        while(i<m):

            if haystack[i]==needle[0]:
                k=i #original position of i
                j=0

                while (j<n and k<m and haystack[k]==needle[j]):
                    j+=1
                    k+=1

                    if (j==n):
                        return i

            i+=1

        return -1

s=Solution()
print(s.strStr("hello" ,"ll"))

"""
Working on optimal solution of kmp algo
"""