# Problem 2 : Find All Anagrams in a String
# Time Complexity : O(m+n) where m is the length of the string s and n is the length of the string p
# Space Complexity : O(n) where n is the length of the string p
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach
from typing import List
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        # get the lenght of both the string s and p
        lengthS = len(s)
        lengthP = len(p)
        # define the hash map for storing the character and its frequency of string p
        hashMap = {} 
        # loop through string p
        for i in range(lengthP):
            # if the character is in hashmap already then increment the frequency
            if p[i] in hashMap:
                hashMap[p[i]] += 1
            # if it is not present then create an entry and set the frequency as 1
            else:
                hashMap[p[i]] = 1

        # define the variables end pointer for string s, 
        # count which will store the number of character match along with frequency
        # result will store the start index of the matched string
        end = 0
        count = 0
        result = []
        # loop through the string s
        while(end < lengthS):
            # get the incoming character of the string at end position
            c = s[end]
            # check if that character is in hash map
            if c in hashMap:
                # if it is present then decrement the value of hash map
                hashMap[c] -= 1
                # if the value of frequency is zero then incrementing the count variable
                # reason since the character with the required frequency is matched with the pattern
                if (hashMap[c] == 0):
                    count += 1
            # for outgoing character first check if the end value is greater than the length of the string p
            if (end >= lengthP):    
                # if it yes then after check the character at end-lengthP position ie outgoing character is in hash map
                if s[end-lengthP] in hashMap:
                    # if it is in hash map then increment the frequency of that character
                    hashMap[s[end-lengthP]] += 1
                    # if the frequency of the character is equal to 1 then decrement the count since the requirement of the character frequency is changed
                    if hashMap[s[end-lengthP]] == 1:
                        count -= 1
            
            # finally check the count variable value and length of the hashMap is equal
            if count == len(hashMap):
                # if it is equal then add the (end-lengthP+1) value to result which is the start index of the string
                result.append(end-lengthP+1)
            # increment the end pointer
            end += 1
        # finally return result
        return result