class ImplementstrStr {
    
    // Approach 1 (non optimal solution) - using two while loop
    // Time complexity - O(mn);
    // Space complexity - O(1)
    // Tested in leetcode
    
    // This function checks needle from each index of haystack
    // Whenever needle is matched the return the index of haystack
    public int strStr1(String haystack, String needle) {
        if(needle == null || needle.length() == 0)
            return 0;
        int n = haystack.length();
        int m = needle.length();
        int j=0,i=0;
        
        // Loop through each element of haystack
        while(i<n){
            j =0;
            int p =i;
            
            // loop through each element of needle and check the matching element between haystack and needle
            // If character at haystak is not matched with the needle corresponding index then break the loop, increment 
            // the index of haystack and again run the this loop to check the presence of needle string into the haystack.
            while(j<m && p < n){
                if(haystack.charAt(p) != needle.charAt(j))
                    break;
                j++;
                p++;
            }
            
            // needle string is iterated upto the end of the length means needle is found in  the haystack
            // return haystack index
            if(j == m)
                return i;
            i++;
        }
        return -1;
    }
    
    // Approach 2 (Optimal solution) - Using LPS algorithm
    // Time complexity - O(m + n);
    // Space complexity - O(m) where m is length of needle
    // Tested in leetcode
    
    // This function use the suffix array created for needle string 
    // use the suffix array to eliminates repetitive iteration
    public int strStr2(String haystack, String needle) {
        if(needle == null || needle.length() == 0)
            return 0;
        int n = haystack.length();
        int m = needle.length();
        int j=0,i=0;
        int[] suffix = getsuffixArray(needle);
        
        // loop through the haystack string and return the ondex where needle is matched
        while(i < n){
            // use two pointer to iterate over each of the string return if j is pointed to end of needle string
            if(needle.charAt(j) == needle.charAt(i)){
                i++;
                j++;
                if(j == m)
                    return i-m;
            }
            else if(j > 0){
                j = suffix[j - 1];            }
            else{
                i++;
            }     
        }
        return -1;
    }
     
    // This function build a suffix array 
    public int[] getsuffixArray(String needle){
        int[] suffix = new int[needle.length()];
        int i=1,len =0;
        
        // loop till the end of the needle string, if match found then increment the element at index
        // if suffix and prefix are not matched element at that index is populated with 0 to indicate there is 
        // no matching.
        while(i < needle.length()){
            if(needle.charAt(i) == needle.charAt(len)){
                suffix[i++] = ++len;
            }
            else if(len == 0){
                suffix[i++] = 0;
            }
            else{
                len = suffix[len-1];
            }     
        }
        return suffix;
    }

}