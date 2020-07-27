# done on July 21
# learnt about prime product

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:

        # Method 3 : Sliding window with dict
        # Time complexity : O(n)
        # only iterating through string s , once
        # Space complexity : O(n) # only dictionary size
        '''
        dict = {}
        for char in p:
            if char not in dict:
                dict[char] = 1
            else:
                dict[char]+=1
        print(dict)

        # move like a sliding window of length of string
        fast = 0
        match = 0
        result = []

        for i in range(len(s)): # index of fast ptr
            # incoming char
            inc = s[i] # in char is our actual pointer
            if inc in dict:
                dict[inc]-=1 # if in dict decrease the count
                if dict[inc] == 0: match+=1

            # out going char
            # when fast comes to index of e ( i.e 3 ), we start using this slow ptr; s: "cbaebabacd" p: "abc"
            if (i>=len(p)) : # this is the start of the point where we start considering incoming char
                out = s[i-len(p)] # index of out ptr ( slow ptr + 1 )
                print(out)
                if out in dict:
                    dict[out]+=1  # increase the count
                    if dict[out] == 1: match-=1

            if match == len(dict) : result.append(i-len(p)+1) # append the slow

        print(result)
        return result

        '''

        # Method 2 : Sliding window Using prime product
        # Time complexity : O(n) ( asymptotically same as method 3)
        # the time is still more than Method 3, because dividing and multiplying takes more time
        # only iterating through string s , once

        # Space complexity : O(1) #no extra space in any DS

        '''
        - similar to method 3, just multiply for incoming char and divide for outgoing char

        Problem :
        - do not make a mistake of calculating pp for every string, it wil be more expensive , rather just multiply and divide

        '''
        primes = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 67, 71, 73, 79, 83, 89, 97, 101, 103];
        final = []

        result_pp = 1
        for char in p:
            result_pp = result_pp * primes[ord(char) - ord('a')]

        result = 1
        for i in range(len(s)):  # index of fast ptr
            # incoming char
            inc = s[i]
            result = result * primes[ord(inc) - ord('a')]

            # out going char
            # when fast comes to index of e ( i.e 3 ), we start using this slow ptr; s: "cbaebabacd" p: "abc"
            if (i >= len(p)):  # this is the start of the point where we start considering incoming char
                out = s[i - len(p)]  # index of out ptr ( slow ptr + 1 )
                # print(out)
                result = result // primes[ord(out) - ord('a')]

            if result == result_pp:
                print(i - len(p) + 1)
                final.append(i - len(p) + 1)

        print(final)
        return (final)





