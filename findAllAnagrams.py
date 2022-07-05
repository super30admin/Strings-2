'''
Time Complexity: 0(s) + 0(p)
Space Complexity: O(1)
Run on leetCode: Yes
'''
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        
        '''return the resultList'''
        resultList = []
        
        # 1. create a dictionary for string p
        dict = {}
        
        for char in p:
            if char not in dict:
                dict[char] = 1
            
            else:
                dict[char] = dict[char] + 1
        
        # 2. initialize slowPtr and fastPtr
        slowPtr = 0
        fastPtr = 0
        
        # 3. maintain strLength
        count = 0
        
        # 4. Iterate the string s
        while fastPtr != len(s):
            
            # logic-case
            # chk for fastPtr postion
            if s[fastPtr] in dict:
                
                # chk for count
                if dict[s[fastPtr]] > 0:
                    # reduce the val
                    dict[s[fastPtr]] = dict[s[fastPtr]]-1
                    count += 1
                    fastPtr += 1
                    
                else:
                    # already zero
                    # give away the reduce count and move slowPtr by 1
                    dict[s[slowPtr]] = dict[s[slowPtr]] + 1 
                    slowPtr += 1
                    count -= 1
            
            # fastPtr not in dict
            elif s[fastPtr] not in dict:
                # return all the progress i.e. give away the reduced count
                while slowPtr != fastPtr:
                    # give away the reduce count and move slowPtr by 1
                    dict[s[slowPtr]] = dict[s[slowPtr]] + 1 
                    slowPtr += 1
                    count -= 1
                # update slowPtr and fastPtr
                slowPtr += 1
                fastPtr += 1
                        
            
            '''chk the length of subString'''
            if count == len(p):
                # I have my anagram
                resultList.append(slowPtr)
                # give away the reduce count and move slowPtr by 1
                dict[s[slowPtr]] = dict[s[slowPtr]] + 1 
                slowPtr += 1
                count -= 1
        '''end of iteration'''
        
        # return the result
        # print("Output list is:\t",resultList)
        return resultList