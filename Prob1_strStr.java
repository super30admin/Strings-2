// Time Complexity : O(m) // m -> Length of haystack string 

// Space Complexity : O(n) // n -> length of needle string
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() > haystack.length()) return -1;
        
        int m  = haystack.length();
        int n = needle.length();
        
        int i = 0, j = 0;
        
        int[] lps = LPS(needle);
        
        while(i < m){
            if(haystack.charAt(i) == needle.charAt(j)){
                j++;  i++;
                if(j == n)  return i - n;
            }else if( (haystack.charAt(i) != needle.charAt(j)) && j > 0 ){
                j = lps[j-1];
            }else if((haystack.charAt(i) != needle.charAt(j)) && j == 0 ){
                i++;
            }
        }
        return -1;
    }
    public int[] LPS(String data){
        int[] lps = new int[data.length()];
        
        int i = 1, j = 0; // lps[0] == 0
        
        while(i < data.length()){
            if(data.charAt(i) == data.charAt(j)){
                j++;
                lps[i] = j;
                i++;
            }else if( (data.charAt(i) != data.charAt(j)) && j > 0 ){
                j = lps[j-1];
            }else if((data.charAt(i) != data.charAt(j)) && j == 0 ){
                lps[i] = j; //j == 0
                i++;
            }
        }
        return lps;
    }
}


/*

// Time Complexity : O( (m - n) * n)   ===== O(mn) // m -> Length of haystack string and n -> Length of needle String

// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int strStr(String haystack, String needle) {
        int m  = haystack.length();
        int n = needle.length();
        
        int i = 0;
        
        while(i < m - n + 1){
            if(haystack.charAt(i) == needle.charAt(0)){
                int j = i;
                int k = 0; //Pointer on needle String            
                while(haystack.charAt(j) == needle.charAt(k)){
                    j++; k++;
                    if(k == needle.length()){
                        return i;
                    }
                }
                
            }
            
            
            i++;
        }
        
        return -1;
    }
}

*/