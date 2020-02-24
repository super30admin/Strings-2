//BruteForce
//Time Complexity: O(m*n)

class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        //edge case
        if(n == 0)
            return 0;
        
        int i = 0;
        //while haystack doesnot reach end
        while(i < m){
            int j = 0;
            //if i and j are equal
            //create temp variable and increment temp and j
            if(haystack.charAt(i) == needle.charAt(j)){
                int temp = i;
                while(temp < m && j < n){
                    //if characters are not equal -> break; increment i
                    //again temp++, j++
                    if(haystack.charAt(temp) != needle.charAt(j)){
                        break;
                    }
                    temp++;
                    j++;
                }
                //if found the substring; return ith index
                if(j == n)
                    return i;
            }
            //if characters are not same; increment i
            i++;
        }
        //if substring not found; return -1
        return -1;
    }
}

/*********************************************************************** */

//Optimal Solution
//Time Complexity: O(n)
class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        //edge case
        if(n == 0)
            return 0;
        
        int[] lps = lps(needle, n);
        
        int i = 0;
        int j = 0;
        //while haystack.length()
        while(i < m){
            //if characters in both the strings is same; increment i and j
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }
            //if j reaches end of string; return n-i length
            if(j == n){
                return i-n;
            }
            //if characters at both the strings are not equal and j>0
            else if(i<m && j>0 && haystack.charAt(i) != needle.charAt(j)){
                j = lps[j-1];
            }
            //if characters at both the strings are not equal and j=0th index
            else if(i<m && j==0 && haystack.charAt(i) != needle.charAt(j)){
                i++;
            }
        }
        return -1;
    }
    
    private int[] lps(String pattern, int n){
        int[] lps = new int[n];
        int i = 1;
        int j = 0;
        lps[0] = 0;
        while(i < n){
            //case1: if characters are equal; 1st increment j, put the index of j as the value at i
            //increment i
            if(pattern.charAt(i) == pattern.charAt(j)){
                j++;
                lps[i] = j;
                i++;
            }
            //case2: if characters are not equal and jth index is > 0
            //put j-1st value into i
            else if(j > 0 && pattern.charAt(i) != pattern.charAt(j)){
                j = lps[j - 1];
            }
            //case3: if characters are not equal and jth index is = 0
            //put ith value as 0, increment i
            else if(j == 0 && pattern.charAt(i) != pattern.charAt(j)){
                lps[i] = 0;
                i++;
            }
        }
        return lps;
    }
}