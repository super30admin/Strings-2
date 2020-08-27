// There are two approaches
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Approach 1: Brute force
// Time Complexity : O(n*m)
//      n: length of haystack
//      m: length of needle
//    Worst case we have matched m-1 characters of needle for every n-1 character of haystack
// Space Complexity : O(1)
class Problem1S1 {

    /** find needle in haystack */
    public int strStr(String haystack, String needle) {

        // edge case
        if(haystack != null && needle != null && haystack.length() >= needle.length()){

            // base case
            if(needle.length() == 0)
                 return 0;
            
            // initilize
            int n = haystack.length();
            int m = needle.length();
            int size = n-m+1; // iteratation size of haystack

            int temp, j;
            
            // iterate haystack
            for(int i =0; i<size; i++){

                // reference to pointer
                temp = i;
                j = 0;

                // check in range and check both equal
                while((j < m && temp < n) && (haystack.charAt(temp) == needle.charAt(j))){
                    temp++;
                    j++;
                }
                
                // complete match
                if(j == m)
                    return i;
                
            }
            
        }
        // not found
        return -1;
    }
}

// Your code here along with comments explaining your approach
// Approach 2: Using KMP (Longest Prefix table)
// Time Complexity : O(n + 2m) = O(n+m)
//      n: length of haystack
//      m: length of needle
//    Worst case we have matched m-1 characters of needle
// Space Complexity : O(m)
//      m: length of needle
//    Prefix table of the needle
class Problem1S2 {

    /** find needle in the haystack */
    public int strStr(String haystack, String needle) {

        // edge case
        if(haystack != null && needle != null && haystack.length() >= needle.length()){

            // base case
            if(needle.length() == 0)
                 return 0;
            
            // initialize
            int n = haystack.length();
            int m  = needle.length();

            // create Prefix table
            int[] lps = getPrefixTable(needle);
            int i =0, j = 0;

            // iterate haystack
            while(i<n){

                // it matches 
                if(haystack.charAt(i) == needle.charAt(j)){
                    i++;
                    j++;
                // check with previous prefixes
                }else if(j>0){
                    j = lps[j-1];
                // no prefixe matched
                }else if(j == 0){
                    i++;
                }
                
                // all matched
                if(j == m)
                    return i-m;
            }
            
        }
        // no match found
        return -1;
    }
    
    /** generate prefix table */
    private int[] getPrefixTable(String needle){

        // initial values
        int m  = needle.length();
        int[] result = new int[m];
        int j = 0;
        int i = 1;

        // iterate the string
        while(i< m){
            
            // both match
            if(needle.charAt(i) == needle.charAt(j)){
                result[i++] = ++j;
            // don't match and might contain prefixes
            }else if(j> 0){
                j = result[j-1];
            // does not contain prefixes
            }else{
                j = 0;
                result[i++] = j;
            }
              
        }

        // return result
        return result;
    }
}