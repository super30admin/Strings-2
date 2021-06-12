"""
Intuition: We will be counting the longest common prefix and suffix in the needle string. 
This pattern will help us to avoid resetting the ith pointer in the haystack string.
#####################################################################
Time Complexity : O(M+N) 
Space Complexity : O(N), N = length of the needle string.
#####################################################################
"""

class Solution {
public:
    int strStr(string haystack, string needle) {
        if ( needle.size() == 0 ) return 0;
        int needleLength = needle.size();
        auto LPS = makePattern(needle);
        int i =0, j =0;
        while ( i < haystack.size()){
            
            if ( haystack[i] == needle[j]){
                j++;i++;
                if ( j == needle.size()){
                    return i - needle.size();
                }
                
            }
            else if (haystack[i] != needle[j] ){
                if ( j ==0){
                    i++;
                }
                else{
                    j = LPS[j-1];
                }
            }
            
            
            
        }
        return -1;
    }
    
    int* makePattern(string needle){
        int LPS [needle.size()];
        for ( int i =0; i < needle.size(); i++){
            LPS[i] = 0;
        }
        int i =1, j =0;
        while ( i < needle.size()){  
            if ( needle[i] == needle[j]){
                j++;
                LPS[i] = j;
                i++;
                    
            }
            else if (needle[i] != needle[j] ){
                if ( j ==0){
                    LPS[i] = 0;
                    i++;
                }
                else{
                    j = LPS[j-1];
                }
            }
        }
        return LPS;
    }
    
};