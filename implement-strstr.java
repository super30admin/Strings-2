// Time Complexity :

// Space Complexity :

// Did this code successfully run on Leetcode :

// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach

approach-1(Naive)

/*
Time Complexity: O((n-m+1)*m) as we are changing the window when needle does not match
and for each window we will check if all the characters of needle match to the window characters

Space Complexity: O(1)
*/
/*
Match every character of the needle to every window in the haystack,
if all of the window characters match all the characters of the needle,
we can return the start index of the window, where we found the answer
*/

class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if (n == 0 && m==0) return 0;
        if (n==0) return -1;
        
        int result = -1;
     //this would change my window start of the window which has size equal to m
        for(int i = 0; i <=n-m; i++){
            int j;
            for(j = 0;j< m;j++){
                if(needle.charAt(j) != haystack.charAt(i+j)){
                    break;
                }
                
            }
            if(j==m){
                result =i;
                break;
            }
        }
        
       return result; 
    }
}