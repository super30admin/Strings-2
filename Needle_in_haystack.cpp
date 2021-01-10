// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    int strStr(string haystack, string needle) {
        if(needle == "" || needle.length()==0){
           return 0;
        }
        if(haystack.length()<needle.length()){
            return -1;
        }
        vector<int> lps(needle.length());
        computelps(needle,lps);
        int i=0, j=0;
        while(i<haystack.length()){
            if(haystack[i]==needle[j]){
                i++;
                j++;
                if(j == needle.length()){
                    return i-needle.length();
                }
            }
            else if(haystack[i]!=needle[j]){
                if(j>0){
                    j = lps[j-1];
                }
                else{
                    i++;
                }
            }
        }
        return -1;
    }
    
    void computelps(string needle, vector<int>& lps){
        int i=1, j =0;
        while(i<needle.length()){
            if(needle[i]==needle[j]){
                j++;
                lps[i]=j;
                i++;
            }
            else if(needle[i]!=needle[j]){
                if(j>0){
                    j = lps[j-1];
                }
                else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
};


// // Time Complexity : O(mxn)
// // Space Complexity :O(1)
// // Did this code successfully run on Leetcode : yes
// // Any problem you faced while coding this : no
// class Solution {
// public:
//     int strStr(string haystack, string needle) {
//         if(needle == "" || needle.length()==0){
//            return 0;
//         }
//         if(haystack.length()<needle.length()){
//             return -1;
//         }
//         for(int i=0;i<haystack.length()-needle.length()+1;i++){
//             int k = i, j=0;
//             for(;j<needle.length();j++){
//                 if(haystack[k++]!=needle[j]){
//                     break;
//                 }
//             }
//             if(j==needle.length()){
//                 return i;
//             }
//         }
//         return -1;
//     }
// };
