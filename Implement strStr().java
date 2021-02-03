/*
tc -O(m*n) space - O(1)
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if needle is None or len(needle) == 0:
            return 0
        
        if len(haystack) < len(needle):
            return -1
        
        for i in range(len(haystack)-len(needle)+1):
            k = i
            j = 0
            while j < len(needle):
                if needle[j] != haystack[k]:
                    break
                
                j += 1
                k += 1
            if j == len(needle):
                return i
        return -1
*/

/*
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if needle is None or len(needle) == 0:
            return 0
        
        if len(haystack) < len(needle):
            return -1
        
        lps = [0]*len(needle)
        self.computelps(lps, needle)
        
        i = 0
        j = 0
        while i < len(haystack):
            if haystack[i] == needle[j]:
                j +=1
                i += 1
                
                if j == len(needle):
                    return i - len(needle)
            else:
                if j > 0:
                    j = lps[j-1]
                else:
                    i += 1
        return -1
    def computelps(self, lps, needle):
        i = 1
        j = 0
        while i < len(needle):
            if needle[i] == needle[j]:
                j += 1
                lps[i] = j
                i += 1
            else:
                if j > 0:
                    j = lps[j-1]
                else:
                    lps[i] = 0
                    i += 1
*/
// Time - O(m) + O(n) where m and n are size of haystack and needle. To calcuate lps array we need O(m) and to iterate through haystack we need O(n)
// Space - O(m) for lps array
// Logic - Used KMP algo to find pattern in string
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0)
            return 0;
        if (haystack.length() < needle.length())
            return -1;
        
        int[] lps = new int[needle.length()];
        computelps(lps, needle);
        int i = 0, j =0;
        while (i < haystack.length()){
            if (haystack.charAt(i) == needle.charAt(j)){
                i ++;
                j ++;
                if (j == needle.length())
                    return i - needle.length();
            }
            else{
                if (j >0)
                    j = lps[j-1];
                else
                    i++;
            }
            
        }
        
        return -1;
    }
    private void computelps(int[] lps, String needle){
        int i = 1, j = 0;
        while (i < needle.length()){
            if (needle.charAt(i) == needle.charAt(j)){
                j ++;
                lps[i] = j;
                i ++;
            }
            else{
                if (j > 0){
                    j = lps[j-1];
                }
                else{
                    lps[i] = 0;
                    i ++;
                }
            }
        }
    }
}
        