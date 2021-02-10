class StrStr {
    /*
      Time : O(N^2) | N being length of haystack
      Space : O(1) 
      Leetcode : Time Limit Exceed
    */
    
    /*
      Approach : 
      1. Iterate through haystack and compare if current char equals to starting char of needle.
      2. If yes then run a while loop for comparing all values of the needle.
      3. At the end of while loop if we have reached to the last index of needle that means whole needle was found inside haystack. 
      4. return startIndex in that case if not return -1;
    */
    public int strStrBF(String haystack, String needle) {
        if(haystack == null || needle == null) return -1;
        
        if(needle.length() == 0 ) return 0;
        
        if(needle.length() == 0 && haystack.length() == 0) return 0;
        
        int startIndex = 0;
        for(int i = 0; i < haystack.length(); i++){
            
            if(haystack.charAt(i) == needle.charAt(0)){
                startIndex = i;
                int indexH = i;
                int indexN = 0;
                while(indexH < haystack.length() 
                      && indexN < needle.length() 
                      && haystack.charAt(indexH) == needle.charAt(indexN)){
                   
                    indexH++;
                    indexN++;
                }
                
                if(indexN == needle.length()){
                    return startIndex;
                }
            }
        }
        
        return -1;
    }
}
