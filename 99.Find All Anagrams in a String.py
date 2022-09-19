class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        result = []
        if len(p) == 0 or len(s) == 0:
            return result
        D = {}
        for i in range(len(p)):
            c = p[i]
            D[c] = D.get(c, 0) + 1

        match = 0

        for i in range(len(s)):
            incoming = s[i]
            if incoming in D.keys():
                count = D.get(incoming)
                # print(count)
                count -= 1
                # print(count)
                D[incoming] = count
                print(D)
                if count == 0:
                    match += 1
                    print(match)

            if i >= len(p):
                out = s[i - len(p)]
                if out in D.keys():
                    count = D.get(out)
                    count += 1
                    D[out] = count
                    if count == 1:
                        match -= 1

            if match == len(D):
                result.append(i - len(p) + 1)

        return result

# TC = O(N+M)
# Space complexity : for Dictionary D O(1) and for List L O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : Syntax error and initially it was returning blank, took sometime to
# understand it was a very small mistake I was returning the result at line number 36  and 38 ,once line number 36
# return was removed it worked fine
