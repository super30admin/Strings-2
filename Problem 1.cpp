//Time Complexity : O(m*n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
class Solution {
public:
    int strStr(string haystack, string needle) {
        string res;
        bool flag;
        if(needle.size()==0){
            return 0;
        }
        if(haystack.size()>=needle.size()){
            for(int i=0; i<haystack.size()-needle.size()+1; i++){
            flag = true;
            for(int j=0; j<needle.size(); j++){
                if(haystack[i+j]!=needle[j]){
                    flag = false;
                    break;
                }
            }
            if(flag == true){
                return i;
            }
        }
        }
        
        return -1;
    }
};