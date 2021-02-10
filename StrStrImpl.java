//Problem : 97 - Implement strStr()
//TC: O(n*m) where n is length of haystack and m is length of needle
//SC: O(1)

/*
Steps : Bruteforce: Iterate over the haystack , check whether current character of haystack matches the needle first character. If it matches, then iterate over the needle and check whether all characters of the haystack are similar to the needle or not. While checking make sure that u have traversed all the characters of needle, if not then also return false

Eg: haystack = "aaa"
    needle   = "aaaa"

*/

class Solution97 {
    public int strStr(String haystack, String needle) {
     
        if(needle==null || needle.length()==0) return 0;
        //TC:O(n*m) where n is length of haystack and m is length of needle
        for(int i=0;i<haystack.length();i++){
            char hayCh = haystack.charAt(i);
            char needCh = needle.charAt(0);
            
            if(hayCh==needCh){
                 if(isFound(haystack,needle,i)){
                     return i;
                 }        
            }
            
        }
        
        return -1;
    }
    
    private boolean isFound(String haystack, String needle, int hayStart){
        int needStart =0;
        
        while(needStart<needle.length() && hayStart<haystack.length()){
            char chNeed = needle.charAt(needStart);
            char chHay  = haystack.charAt(hayStart);
            
            if(chNeed!=chHay) return false;
            
            needStart++;
            hayStart++;
        }
        
        if(needStart<needle.length()) return false;
        
        return true;
    }
}