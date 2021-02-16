//Problem : 97 - Implement strStr()
//TC: O(n+m) where n is length of haystack and m is length of needle
//SC: O(m)

/*
Steps : 1) Bruteforce: O(n*m) where n is length of haystack and m is length of needle
        Iterate over the haystack , check whether current character of haystack matches the needle first character. If it matches, then iterate over the needle and check whether all characters of the haystack are similar to the needle or not. While checking make sure that u have traversed all the characters of needle, if not then also return false

Eg: haystack = "aaa"
    needle   = "aaaa"

        2) Optimized : O(m+n) SC:O(m) | Using KMP algorithm-> Used when substring search or matching is required. Check notes.
        Find the Lowest Prefix Suffix Length, for the pattern string which is needle. After that use lps for comparing haystack and needle

        Eg: find LPS : a a a c a a a a 
                       0 1 2 0 1 2 3 3

*/

//Optimized using KMP
class Solution97 {
    public int strStr(String haystack, String needle) {
        
        if(needle==null || needle.length()==0) return 0;
        //TC:O(m+n), m is needle length, n is haystack length
        //SC: O(m), lps array for needle whic is pattern
        int[] lps = getLPS(needle);
        
        int j=0;
        int i=0;
        
        while(i<haystack.length()){
            
            if(haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
                //pattern matched
                if(j==needle.length()) return i-needle.length();
                
            }else if(haystack.charAt(i)!=needle.charAt(j) && j>0){
                j = lps[j-1];//move j to lps value of previous j index
            }else if(haystack.charAt(i)!=needle.charAt(j) && j==0){
                i++;
            }
            
        }
        
        
        return -1;
    }
    
    //Get Longest Prefix Suffix using KMP Algorithm
    private int[] getLPS(String s){
        
        int[] lps = new int[s.length()];
        
        int j=0;//winStart
        int i=1;//winEnd
        while(i<s.length()){
            
            if(s.charAt(i)==s.charAt(j)){
                
                j++;
                lps[i] = j;
                i++;
                
            }else if(s.charAt(i)!=s.charAt(j) && j>0){
                j = lps[j-1];//move j to lps value of previous j index
            }else if(s.charAt(i)!=s.charAt(j) && j==0){
                lps[i] = 0;//when j is at start i.e 0, make current index value to 0 and move further
                i++;
            }
            
        }
        
        return lps;
    }
    
}


/* Bruteforce: TC:O(m*n)
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
*/