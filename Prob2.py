class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        #Method 1 Brute force - create all possible substrings and check -> implemented using 3 pointers - TC O(mxn) and O(1) SC
        # m=len(haystack)
        # n=len(needle)

        # if n>m: return -1
        # i=0

        # while i<=m-n: #using i to generate all substrings
        #     j=0 #use j to iterate over needle
        #     if haystack[i]==needle[j]:
        #         k=i #using k to go over current substring in haystack
        #         while haystack[k]==needle[j]:
        #             k+=1
        #             j+=1
        #             if j==n: #if we reached end of needle, we done
        #                 return i
        #     i+=1
        # return -1

        # Method-2- Robin Karp method using rolling hash - TC - O(m+n) and O(1) SC
        needle_hash=0
        n=len(needle)
        k=26
        for need in needle:
            val=ord(need)-ord('a')+1 #+1 cause, we want the range from 1-26 and not 0-25
            needle_hash=needle_hash*k+val #rolling hash of needle
        check=0
        for i in range(len(haystack)):
            val=ord(haystack[i])-ord('a')+1  #+1 cause, we want the range from 1-26 and not 0-25
            if i<n:
                check=check*k+val #if i<n, no outgoing element, so keep adding new incoming elements
            else:
                incoming_ele=haystack[i]
                outoing_ele=haystack[i-n]
                outgoing_val=ord(outoing_ele)-ord('a')+1 
                incoming_val=ord(incoming_ele)-ord('a')+1
                check=check*k+incoming_val-outgoing_val*(k**n) #add incoming val and subtract the outgoing val with correct rolling hash value->K**n. 
            if check==needle_hash:
                return i-n+1
        return -1





