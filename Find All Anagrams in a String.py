"""
438. Find All Anagrams in a String
Time Complexity - O(n) n is length of largesr string
Space Complexity -O(m) m is length of smaller string
So here we have stored character of p in a hashmap in character:count pattern
incoming logic:
Then using sliding window method we keep on checking if size of window == len(p) and if character is present in hashmap declement its count by 1 and if count is 0 increment match 
Outgoing logic:
Once the window size is exceeded check window start element present in hashmap if yes then increase the count by 1 and now if count is 1 then decrement match by 1

Once match == len(hashmap) just append start value to output

"""
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        
        output = []
        if p == None or len(p) == 0:
            return output
        hashmap ={}
        #Putting p characters in hashmap
        for i in range(len(p)):
            if p[i] in hashmap:
                hashmap[p[i]] += 1
            else:
                hashmap[p[i]]  = 1
        
        start = 0
        end = 0
        match = 0
        while(end < len(s)):
            #incoming
            if s[end] in hashmap:
                hashmap[s[end]] -= 1
                if hashmap[s[end]] == 0:
                    match += 1
            #outgoing
            if (end-start+1) > len(p):
                if s[start] in hashmap:
                    hashmap[s[start]] += 1
                    if hashmap[s[start]] == 1:
                        match -= 1
                start += 1
            if match == len(hashmap):
                output.append(start)
            
            end += 1
        return output
            
        