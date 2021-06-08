/*Running time Complexity: O(mxn)
Space Complexity: Constant
Sucessfully run and compiled on leetcode
*/
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0) return 0;
        int slow = 0;
        int i = 0;
        int n = needle.length(); int m = haystack.length();
        while(i<haystack.length() - needle.length()+1){
            if(haystack.charAt(i)==needle.charAt(0)){//compare 1st element of needle with haystack elements
                int k = i;
                int j = 0;
                while(j<needle.length() && k< haystack.length() && haystack.charAt(k)==needle.charAt(j)){
                    k++;j++;
                    if(j==needle.length()) return i;
                 }
             }
           i++;
        }
     return -1;   
    }
}