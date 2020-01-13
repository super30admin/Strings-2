/**
LeetCode Submitted : YES
Space Complexity : O(1)
Time Complexity : O(haystack*haystack)

The idea is to use to iterate the charachters in each haystack and compare it with needle. if we exhaust all characters in needle we return first found index in haystack othrwise if we exhaust all charachters in haystack we return -1.

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
        int result = -1;
        
        while(first < haystack.length() && second < needle.length()){
            char c1 =  haystack.charAt(first);
            char c2 =  needle.charAt(second);
            
            //Potential first character match
            if(c1 == c2){
                if(second == 0){
                    result = first;
                }
                
                if(second == needle.length() -1)
                    return result;
                
                second ++;
                first++;
                
            }else{
                if(second == 0)
                    first++;
                else{
                    second = 0;
                    first = result + 1;
                }
            }
        }
        
        return -1;
    }
}
