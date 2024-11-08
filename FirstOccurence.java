class Solution {
    public int strStr(String haystack, String needle) {
        int m=haystack.length();
        int n=needle.length();
        
        int pHash=0;
        int prime=10000001;
        for(int i=0;i<n;i++){
            char c=needle.charAt(i);
            pHash=(pHash*26+(c-'a'+1))%prime;
        }
        int currHash=0;
        
        int posFac=1;
        for(int i=0;i<n-1;i++){
            posFac=(posFac*26)%prime;
        }
        for(int i=0;i<m;i++){
            
             if(i>=n){
                char out=haystack.charAt(i-n);
                currHash=(currHash- posFac*(out-'a'+1))%prime;
            }
            char in=haystack.charAt(i);
            currHash=(currHash*26+(in-'a'+1))%prime;
            
            if(currHash<0) currHash+=prime;
           
            if(currHash==pHash){
                return i-n+1;
            }
        }
        
        
        return -1;
    }
}