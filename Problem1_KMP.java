/**
LeetCode Submitted : YES (KMP Algorithm)
Space Complexity : O(1) 
Time Complexity : O(len(haystack) + len(needle))

The idea is to use to least common suffix/prefix array. The array will be of needle length such that for each position we will check 3 cases as mentioned to check character at each i and j. Also, we will move our second pointer in needle array to appropriate position if there is a mismatch.

**/
class Solution {
    public int strStr(String haystack, String needle) {
     
        if(haystack.equals(needle))
            return 0;
        
        if(needle.equals(""))
            return 0;
        
        if(needle.length() > haystack.length())
            return -1;
        
        int first = 0;
        int second = 0;
        
        int[] lps = generateLPS(needle);
        
        
        while(first < haystack.length()){
            char c1 =  haystack.charAt(first);
            char c2 =  needle.charAt(second);
            
            
            //Potential first character match
            if(c1 == c2){
                if(second == needle.length() -1)
                    return first-second;
                
                second ++;
                first++;
                
            }else{
                //No match characters
                if(second == 0)
                    first++;
                else{
                    //Partial match character use LPS optimization
                    second = lps[second - 1];
                }
            }
        }
        
        return -1;
    }
    
    private int[] generateLPS(String s){
        int[] lps = new int[s.length()];
        
        int i = 1;
        int j = 0;
        
        while(i < lps.length){
            //Find Character at each i and j position 
            char c1 = s.charAt(j);
            char c2 = s.charAt(i);
            
            //case 1 if characters in prefix are equal 
            if(c1 == c2){
                j++;
                lps[i] = j;
                i++;
            }else if(j >0 && c1 != c2){ 
                //Not equal move to last matching char position
                j = lps[j-1];
            }else{
                lps[i] = j;
                i++;
            }
        }
        return lps;
    }
}
