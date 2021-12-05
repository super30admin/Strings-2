// Time Complexity : O(N+M)
// Space Complexity : O(N) needle length
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int strStr(String haystack, String needle) {
        if(needle=="" || needle.length()==0) return 0;
        int[] lps=lps(needle);
     
        
        int i=0;
        int j=0;
        while(i<haystack.length()){
            char ci=haystack.charAt(i);
            char cj=needle.charAt(j);
            if(ci==cj){
                i++;
                j++;
                if(j==needle.length()){
                    return i-j;
                }
            }else{
                if(j!=0){
                j=lps[j-1];
                }else{
                   i++; 
                }
            }
        }    
        return -1;        
    }
    
    public int[] lps(String needle){
        int[] lps=new int[needle.length()];
        int i=1;
        int j=0;
        lps[0]=0;
        while(i<needle.length()){
            char ci=needle.charAt(i);
            char cj=needle.charAt(j);
            if(ci==cj){
                j++;
                lps[i]=j;
                i++;
                
            }else if(ci!=cj && j!=0){
                j=lps[j-1];
            }else if(ci!=cj && j==0){
                lps[i]=0;
                i++;
            }
        }
        return lps;
    }
}