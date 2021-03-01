# // Time Complexity : O(m+n) 
# // Space Complexity : O(1) Since hasmap can be max of 26 length
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach: WINDOW
# use hashmap to store the occurances of the characters from the P string
# move the window from left to right
# look at the incoming char and outgoing char
# when incoming char is in hashmap decrese the count of that char in hashmap, increase the match by 1
# when outgoing char is in hashmap increase the count of that char in hashmap, decrese the match by 1
# for each window check if match == len(hashmap): if that it the case append start index to res



class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        
        hashmap = {}
        #put count of p in hashmap
        for i in p:
            if i not in hashmap:
                hashmap[i]=1
            else:
                hashmap[i] += 1
        match = 0 
        res = []
        # run for loop on s
        for end in range(len(s)):
            #incoming character
            inc = s[end]
            # if incoming char is in hashmap decrese it count and update the match if thats 0
            if inc in hashmap:
                hashmap[inc] -= 1
                if hashmap[inc] == 0:
                    match += 1
            
            #outbound
            if end>=len(p):
                out = s[end - len(p)]
                if out in hashmap:
                    hashmap[out] += 1
                    if hashmap[out] == 1:
                        match -= 1
            if match == len(hashmap):
                res.append(end - len(p)+1)
        return res
        