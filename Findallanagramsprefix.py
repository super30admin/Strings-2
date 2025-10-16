class Solution(object):
    # tc : O(n+m) where n is the len. of the p and m is the len of s
    # sc : O(1) for storing at max 26 letters in the hashmap
    # ran successfully on leetcode 
    def findAnagrams(self, s, p):
        # trcik part : its not just the p string to match but even if it match to an anagram then we have to store the index
        # for taking care of anagram check i will maintian a hshamp where i store the chracters and its count of the p 
        # and slide through a window and if the chractrs matchi will reduce the frequency of the charaters in the map, if at a point an y character frequncry has become 0 means we have succeffully matched up a character , exactly the required frequncy times
        # and if our match count == the p hashmap count, then we found the anagram , we will store the start index of this window and we wil move next to the slide window
        # but since we already reduced the count of the chracters in the hashmap of p while we are moving window more than len(p) chars lets restore the letters we and the count we have removed in the previous window
        
        # store the freuqncy coutn of p
        hash_map_p = {} # tc : O(n)
        for char in p:
            if char not in hash_map_p:
                hash_map_p[char] = 0
            hash_map_p[char] +=1

        # slide the window to get the prefixes

        chars_match = 0
        result = []
        n = len(p)
        for i in range(len(s)): # tc : O(m)
            if s[i] in hash_map_p:
                hash_map_p[s[i]] -=1 # reduce the frequency count of the chracters
                # note here we are not deleting the characters in the hasmap just reducing its frequency
                if hash_map_p[s[i]] == 0:
                    chars_match +=1

            # the above for loop will take care of the window and the match count 
            # lets say we are moving more than the anagram length 

            if i >=n:
                restore_char = s[i-n] # the start index charater lets restore it
                if restore_char in hash_map_p:
                    hash_map_p[restore_char] += 1
                    if hash_map_p[restore_char] == 1: # after addition it became 1 then before it was 0 so this is allocated in our matchcount which should be reduced as this letter is no longer in our window
                        chars_match -=1
            
            if chars_match == len(hash_map_p):
                result.append(i-n+1)
        
        return result


