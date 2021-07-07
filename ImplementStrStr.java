/*
method 1 - 
brute force approach
try all possble substring by comparing each char. When mismatach occurs reset the pointers of string 1 and 2. 

This will take O(m x n)times.

method 2 - KMP algorithm
2 pointers to explore prefix and suffix  of both the strings.
advance ptr1 and ptr2 until there is an matching char. Once char does not matches and j >0,
then put ptr2 to location to the last matching char. 

Time complexity: O(n)


*/
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0)return 0;
        
        // for(int i = 0;i < haystack.length();i++){
        //     if(needle.charAt(0) == haystack.charAt(i)){
        //         int j = i;
        //         int k = 0;
        //         while(j < haystack.length() && needle.charAt(k) == haystack.charAt(j)){
        //             k++;j++;
        //             if(k == needle.length()){
        //                 return i;
        //             }
        //         }
        //     }
        // }
        // return -1;
        
        int[]LPS = new int[needle.length()];
        LPS[0] = 0;
        
        int i = 1;
        int j = 0;
        while(i < needle.length()){
            if(needle.charAt(i) == needle.charAt(j)){
                j++;
                LPS[i] = j;      //adding the length prefix/suffix of matched characters
                i++;
            }
            else if(needle.charAt(i) != needle.charAt(j) && j > 0){
                j = LPS[j-1]; //put back j to postion where prefix suffix were matching
            }
            else if(needle.charAt(i) != needle.charAt(j) && j == 0){
                LPS[i] = 0;//no common prfix or suffix found. So start again.
                i++;
            }
        }
        
         i =0;
         j = 0;
        while(i < haystack.length() ){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
                if(j == needle.length()){
                    return i - needle.length();
                }
            }
            else if(j > 0 && haystack.charAt(i) != needle.charAt(j)){
                j = LPS[j-1];
            }else if (j == 0 && haystack.charAt(i) != needle.charAt(j)){
                i++;
            }
        } 
        return -1;
    }
}