//Time - O(len(haystack))
//Space - O(len(needle))

class Solution {
public:
    int strStr(string haystack, string needle) {
        int h = haystack.length();
        int n = needle.length();
        if(n == 0) return 0;
        if(h<n) return -1;
        
        vector<int> lps(n,0);
        computeLps(needle, lps);
        
        int i=0,j=0;
        while(i<h){
            if(haystack[i] == needle[j]){
                i++;j++;
                if(j == needle.length()){
                    return i-needle.length();
                }
            }else{
                if(j==0){
                    i++;
                }else{
                    j = lps[j-1];
                }
            }
        }
        return -1;
            
    }
    
    void computeLps(string needle, vector<int>& lps){
        int i=1,j=0;
        
        while(i<needle.length()){
            if(needle[i] == needle[j]){
                j++;
                lps[i] = j;
                i++;
            }else if(needle[i]!=needle[j]){
                if(j==0){
                    lps[i] = 0;
                    i++;
                }else {
                    j = lps[j-1];
                }
            }
        }
    }
};