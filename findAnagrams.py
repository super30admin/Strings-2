#Time Complexity : O(m+n) where n is the length of the input string
#Space Complexity : O(1) as the hashmap can be max of 26 letters
#Did this code successfully run on Leetcode : Yes

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        #make a counts dictionary for the pattern
        countsP = collections.Counter(p)
        result = []
        matching = 0
        for i in range(len(s)):
            #check if curr char in string exists in the pattern
            if s[i] in countsP:
                #reduce count of the curr char in the pattern as we're adding it to out substring
                countsP[s[i]] -= 1
                #if we've found all occurances of that char in our string till now, we can say we've finished matching one letter
                if countsP[s[i]] == 0:
                    matching += 1
            #if our substring has atleast p characters where p is the lenght of the pattern
            if i >= len(p):
                #increase count of the curr char in the pattern as we're removig that char from our substring
                if s[i-len(p)] in countsP:
                    countsP[s[i-len(p)]] += 1
                #if we've now lost a char from our pattern then we have not found all the occurances of that char in our substrign till now
                if countsP[s[i-len(p)]] == 1:
                    matching -= 1
            #if we've found all characters in our pattern in our substring then we can append the start index of that substring to our result
            if matching == len(countsP):
                result.append(i-len(p)+1)

        return result
