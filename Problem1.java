//TC : O(n) where n is the length of Haystack string.
//SC:  O(1)

//Idea : check the first element of needle in haystack string and return the index. 
//LC Run: Not successfull, 

class Solution {
    public int strStr(String haystack, String needle) {
        if((needle == "") || (needle.length() == 0)) return 0;
        if(haystack!=null && needle!=null && needle.length()>0
          && haystack.indexOf(needle)!=-1){
            for(int i=0;i<haystack.length();i++){
                if(haystack.charAt(i) == needle.charAt(0)){
                    return i;
                }
            }
        }
        return -1;
    }
}
