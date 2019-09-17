# Time Complexity : O(n*m) when n is length of string s and m is the length of pattern p
# Space Complexity :O(n) when n is length of string s
# Did this code successfully run on Leetcode :Yes
# Any problem you faced while coding this : No


class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:

        # if length of pattern or string is less than 1 then return nothing
        # if length of pattern is less than that of string then return nothing
        if len(s) < 1 or len(p) < 1 or len(p) > len(s):
            return []

        else:
            # created arrP and arrS for maintaining the occurences of letters on pattern and string for                the purpose of comparison
            arrP = [0] * 26
            arrS = [0] * 26
            result = []

            # FUnctin for comparing two lists
            def listComparator(l1, l2):
                return l1 == l2

            # Filling the list for the pattern
            for char in p:
                arrP[ord(char) - 97] += 1

            # Filling the list for the string starting from 0 to length of pattern
            for i in range(0, len(p)):
                arrS[ord(s[i]) - 97] += 1

            # Comparison of first window with the pattern
            if listComparator(arrP, arrS):
                result.append(0)

            # Iteration from 1 to len(s) - len(p)+1
            for i in range(1, len(s) - len(p) + 1):
                # Removing the first element of the last window
                arrS[ord(s[i - 1]) - 97] -= 1
                # Inserting the last element of the window
                arrS[ord(s[i + len(p) - 1]) - 97] += 1

                # COmparison of window string with the pattern
                if listComparator(arrS, arrP):
                    result.append(i)
            return result
