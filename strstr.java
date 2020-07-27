//Time complexity:O(m+n)
//Space complexity:O(n)

class Solution {
    public int strStr(String haystack, String needle) {
        int m=haystack.length();
        int n=needle.length();
        if(haystack.length()<needle.length()){
            return -1;
        }
        if(n==0){
            return 0;
        }
        int i=0;
        int j=0;
        int[] lps=lps(needle);
        while(i<m){
            if(haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
            }
            if(j==n){
                return i-n;
            }
            if(i<m && j>0 && haystack.charAt(i)!=needle.charAt(j)){
                j=lps[j-1];
            }
            if(i<m && j==0 && haystack.charAt(i)!=needle.charAt(j)){
                i++;
            }
        }
        return -1;
        
    }
    
    private int[] lps(String needle){
        int[] lps=new int[needle.length()];
        int i=1;
        int j=0;
        lps[0]=0;
        while(i<needle.length()){
            if(needle.charAt(i)==needle.charAt(j)){
                j++;
                lps[i]=j;
                i++;
            }
            else if(j>0 && needle.charAt(i)!=needle.charAt(j)){
                j=lps[j-1];
            }
            else if(j==0 && needle.charAt(i)!=needle.charAt(j)){
                lps[i]=0;
                i++;
            }
        }
        return lps;
    }
}