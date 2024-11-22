class Solution {
    public int strStr(String haystack, String needle) {
        int n=haystack.length();
        int m=needle.length();
        int prime=10000001;
        int nhash =0;
        int pos=1;
        for(int i=0;i<m;i++){
            pos=(pos*26)%prime;
        }
        for(int i=0;i<m;i++){
            char c = needle.charAt(i);
            nhash=(nhash*26+c-'a'+1)%prime;
        }
        int hash=0;
        for(int fast=0;fast<n;fast++){
            char in = haystack.charAt(fast);
            hash=(hash*26+in-'a'+1)%prime;

            if(fast>=m){
                char out=haystack.charAt(fast-m);
                hash=(hash-pos*(out-'a'+1))%prime;
            }
            if(hash<0) hash+=prime;            
            if(hash==nhash) return fast-m+1;
        }
        return -1;
    }
}
