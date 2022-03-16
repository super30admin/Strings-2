class Solution {
    public int strStr(String haystack, String needle) {
         if(needle.length() == 0) return 0;
      
    int m = haystack.length();
    int n= needle.length();
    int i=0; int j=0;
        if(n> m) return -1;
    int [] lps = lps(needle);
  
    while(i < m){
     
        if(haystack.charAt(i)== needle.charAt(j)){
            i++; j++;
            if( j==n) return i-n;
        }
        else if(j>0 && haystack.charAt(i) != needle.charAt(j)){
            j=lps[j-1];
        }
        else if(j==0 && haystack.charAt(i) != needle.charAt(j))
        i++;
    }
    return -1; 
        }
    
    private int[] lps(String needle){
        int[] lps= new int[needle.length()];
        lps[0]= 0;
        int j=0; int i=1;
        while(i< needle.length()){
            if(needle.charAt(i)== needle.charAt(j)){
                 j++;
                lps[i]=j;
                i++; 
            }
            else if(j>0 && needle.charAt(i) != needle.charAt(j)){
                j= lps[j-1];
            }
            else if(j==0 && needle.charAt(i) != needle.charAt(j)){
                lps[i]=j;
                i++; 
            }
        }
        return lps;
    }
}

//Time- O(m+n) bt is very small
// Space complexity- O(m0