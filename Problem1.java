//Time Complexity : O(m*n)
//Space Complexity : O(1)

class Solution {
    public int strStr(String haystack, String needle) {
        
        if(needle==null || needle.length()==0 ){
            return 0;
        }
         if(haystack==null || haystack.length()==0 ){
            return -1;
        }
        if(needle.length()>haystack.length()){
            return -1;
        }
        
        char ch = needle.charAt(0);
        int hlen=haystack.length();
        int nlen = needle.length();
        
        for(int i=0; i<hlen;i++){
            if(haystack.charAt(i)!=ch){
                continue;
            }else{
                int hindex=i;
                int nindex=0;
                while(hindex<hlen && nindex<nlen){
                    if(haystack.charAt(hindex)!=needle.charAt(nindex)){
                        break;
                    }
                    hindex++;
                    nindex++;
                }
                
                if(nindex==nlen){
                    return i;
                }
            }
            
        }
        
        return -1;
        
    }
}