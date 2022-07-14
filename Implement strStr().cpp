//Time Complexity- O((m-n)n)
//Space Complexity- O(1)

class Solution {
public:
    int strStr(string haystack, string needle) {
        
        if(haystack.size()<needle.size()){
            return -1;
        }
        for(int i=0;i<=haystack.size()-needle.size();i++){
            string curr=haystack.substr(i,needle.size());
            if(curr==needle){
                return i;
            }
        }
        return -1;
    }
};