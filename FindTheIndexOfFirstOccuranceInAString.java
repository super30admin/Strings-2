// Time Complexity: O(mn) //length of both string
// Space Complexity: O(1)

/*
 * track the elements we travese. if it is equal to needle check for
 * other elements in the stack now if the whole needle is found in  
 * haystack return the start index. else return -1
 */


class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        int i = 0, j = 0, k = 0;
        while(i <= m-n){
            if(haystack.charAt(i) == needle.charAt(0)){
                k = i;
                j = 0;
                while(haystack.charAt(k) == needle.charAt(j)){
                    k++; j++;
                    if(j == n){
                        return i;
                    }
                }
            }
            i++;
        }
        return -1;
    }
}