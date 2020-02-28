// Time Complexity : O(M+N)
// Space Complexity : O(N) N Length of needle string
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if(n==0){
            return 0;
        }
        int [] lps = lps(needle,n);
        
        int i = 0;
        int j = 0;
        
        while(i < m){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }
            
            if(j == n){
                return i - n;
            }
            
            if(i < m && j > 0 && haystack.charAt(i) != needle.charAt(j) ){
                j = lps[j-1];
            }
            
            else if(i < m && j == 0 && haystack.charAt(i) != needle.charAt(j)){
                i++;
            }
        }
        
        return -1;
    }
    
    private int [] lps(String needle, int n){
        int [] lps = new int [n];
        int i = 1;
        int j = 0;
        lps[0] = 0;
        
        while(i < n){
        //case1
        
        if(needle.charAt(i) == needle.charAt(j) ){
            j++;
            lps[i] = j;
            i++;
        }
        //case2
        
        else if(j > 0 && needle.charAt(i) != needle.charAt(j)){
            j = lps[j-1];
        }
        //case3
        
        else if(j == 0 && needle.charAt(i) != needle.charAt(j) ){
            lps[i] = 0;
            i++;
        }
        }
        return lps;
    }
        /*
        if(n == 0){
            return 0;
        }
        int i = 0;
        while(i < m){
            int j = 0;
            if(haystack.charAt(i) == needle.charAt(j)){
                int temp = i;
                while(temp < m && j < n){
                    if(haystack.charAt(temp) != needle.charAt(j)){
                        break;
                    }
                    temp++;
                    j++;
                }
                if(j == n){
                    return i;
                }
            }
            i++;
        }
        
        return -1;
    }*/
}