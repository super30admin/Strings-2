// Optinized TC: O(n)

class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        int i=0;    //hay ptr
        int j=0;    //needle ptr
        int []lps= lps(needle);
        
        while(i<m){
            if(haystack.charAt(i)==needle.charAt(j)){
                j++;    //j is incoming character in prefix window, will give length of longest pref window
                i++;
                if(j==n) return i-n;
            }
            else if(needle.charAt(j)!=haystack.charAt(i) && j>0){
                j=lps[j-1];
            }else if(needle.charAt(j)!=haystack.charAt(i) && j==0){
                i++;
            }
        }
        
        return -1;
    }
    
    private int[] lps(String needle){
        int []lps= new int[needle.length()];
        lps[0]=0;
        int j=0;
        int i=1;
        
        while(i<needle.length()){
            if(needle.charAt(j)==needle.charAt(i)){
                j++;    //j is incoming character in prefix window, will give length of longest pref window
                lps[i]=j;
                i++;
            }
            else if(needle.charAt(j)!=needle.charAt(i) && j>0){
                j=lps[j-1];
            }else if(needle.charAt(j)!=needle.charAt(i) && j==0){
                lps[i]=0;
                i++;
            }
        }
        return lps;
    }
}
