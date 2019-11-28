#leetcode 438
#brute force -- find all the possible anagrams and check in the parent string:--  time - exponential
#optimal using
#algo : Create a hashmap for the anagram string, npw check in the given string with a rolling window
#space: O(1)
#time : O(N)
class Solution:
    def findAnagrams(self, s, p):
        result = []
        # edge case
        if not(s) or not(p) or len(s) == 0 or len(p) == 0:
            return result

        hash_map = {} #create an empty dictionary
        match = 0
        for c in p: #for p create a=has map with the values of the letters and how many times its repeating
            if c in hash_map:
                hash_map[c] += 1
            else:
                hash_map[c] = 1
        i = 0
        while i < len(s): #printing the
            c = s[i]
            if c in hash_map:
                hash_map[c] -= 1
                if hash_map[c] == 0:
                    match += 1

            if i >= len(p): #window length onces it crosees, then we shoud keep appending and deleting elements
                c = s[i - len(p)]  #deleting the intital element
                if c in hash_map:
                    if hash_map[c] == 0:
                        match -= 1
                        hash_map[c] = 1
                    else:
                        hash_map[c] += 1

            if match == len(hash_map): #even if a letter levaes if the same element eneters then match is brought back to len of hashmap and the that start
                result.append(i - len(p) + 1) #appending the match element
            i += 1
        return result