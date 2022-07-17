#Time complexity : O(n) where m is the length of n is the length of s string
#Space complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#youtube : https://youtu.be/you_8asVfXk
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        result = []
        #null condition
        if len(p) ==0:
            return result
        if len(s)<len(p):
            return result
        #creating hashmap for storing the characters and there occurence in of pattern string
        hashmap = {}
        for i in p:
            hashmap[i] = hashmap.get(i,0)+1
        #maintaining the variable match for keeping track of the match found fromm the p string
        match = 0
        count =0
        #iterating over the string s
        for i in range(len(s)):
            #for the incoming character
            #checking if the incoming character is there is the window
            incoming = s[i]
            if incoming in hashmap:
                count = hashmap.get(incoming,0)
                count -=1
                if count ==0:
                    #if the count change from 1 to 0 at that time only we will change the match by 1
                    match +=1
                hashmap[incoming] -=1
                
            #we are not doing anything for outgoing characters till the size of window is equal to the size of the pattern
            if i >= len(p):
                #performing outgoing funtion
                outgoing = s[i-len(p)]
                if outgoing in hashmap:
                    count = hashmap.get(outgoing,0)
                    count +=1
                    if count == 1:
                        #if there is change in value from 0 to 1 then only we will decrease the match character
                        match -=1
                    hashmap[outgoing] += 1
            #checking if match value is equal to the value of the map size then we found the anagram window and we will store the result
            if match == len(hashmap):
                result.append(i - len(p)+1)
        return result
