#Time Complexity : O(N+M), N and M being the length of the strings. 
#Space Complexity : O(1).
#Did this code successfully run on Leetcode : Yes.
#Any problem you faced while coding this : Had to debug because I had calculated the hash incorrectly in all the 
#wrong ways. Had to crack out a calculator to see what I did wrong.
#Your code here along with comments explaining your approach in three sentences only
'''Create a hash for needle and then calcalating the hash for haystack while parsing through the 
the remainder of haystack for each length of haystack equal to needle length. 
'''
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        #initialize and take care of case where haystack is shorter than needle. 
        if len(haystack)<len(needle):
            return -1
        result = -1
        #calculate hash of needle. 
        needle_hash = 0
        for i in range(len(needle)):
            c=needle[i]
            ascii_val = ord(c)-ord('a')  
            needle_hash = needle_hash*26+ascii_val
        #calculate the hash of the first n characters of haystack. 
        n_length = len(needle)
        haystack_hash=0
        for i in range(len(needle)):
            c = haystack[i]
            ascii_val = ord(c)
            ascii_val = ord(c)-ord('a')
            haystack_hash = haystack_hash*26+ascii_val
        if needle_hash==haystack_hash:
            return 0
        #parse through remainder of haystack and calculate the new hash. 
        for i in range(n_length, len(haystack)):
            c = haystack[i]
            ascii_val = ord(c)
            ascii_val = ord(c)-ord('a')
            n=(26**(n_length-1))*(ord(haystack[i-n_length])-ord('a'))
            haystack_hash = haystack_hash-n
            haystack_hash = haystack_hash*26+ascii_val
            if needle_hash==haystack_hash:
                return i-n_length+1
        return -1

                


                

