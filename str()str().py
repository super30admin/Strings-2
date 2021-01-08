class Solution(object):
    #lps array
    #O(haystack)
    #O(needle)
    
    def setupTable( self,needle):
            table = [0]*len(needle)
            #only one char> so first char answer is zero>cant be prefix or suffix
            table[0]=0
            #compare alternate characters
            i = 0
            j = 1
            #move fast pointer till end of array
            while j < len(needle):
                #if chars match>move forward both
                if needle[j] == needle[i]:
                    #fill lps index by slow pointer+1
                    table[j]=i+1
                    i += 1
                    j+=1
                #mismatch
                elif needle[j] != needle[i]:
                    #if slow pointer has moved to internal window index>
                    #make it go back to previous matched index
                    if i>0:
                        i=table[i-1]
                    #if slow is at start index only>just advance fast and keep checking
                    else:
                        j += 1  
            return table
    
                
    def strStr(self, haystack, needle):
        #base
        if len(needle) == 0:
            return 0
        
        table =self.setupTable(needle)
        needleLength = len(needle)
        #both start at 0
        
        #needle index
        counter = 0
        #haystack index
        i = 0
        while i < len(haystack):
            char = haystack[i]
            #match>advance both
            if needle[counter] == char:
                counter += 1
                i+=1
                #full match>just return ans
                if counter == needleLength:
                    return i - needleLength
            #mismatch case>follow same lps array case
            elif needle[counter] != char:
                if counter>0:
                    counter = table[counter - 1]
                else:
                    i += 1
        return -1              