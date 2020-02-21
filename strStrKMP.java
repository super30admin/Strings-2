//TC : O(m+n) ,m and n are length of string and pattern respectively
//SC : O(n) where n is the length of the pattern


class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        
        if(n == 0)
            return 0;
        
        int[] lps = findLongestPrefix(needle);
        
        System.out.println(Arrays.toString(lps));
        
        int i=0,j=0;
        
        while(i < m){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;j++;
            }
            if(j==n){
                return i - n;
            }
            else if( i<m && j>0 && haystack.charAt(i) != needle.charAt(j)){
                j = lps[j-1];
            }
            else if ( i<m && j==0 && haystack.charAt(i) != needle.charAt(j)){
                i++;   
            }
        }
        
        return -1;
        
    }
    
    
    private int[] findLongestPrefix(String needle){
        int[] lps = new int[needle.length()];
        
        int j=0,i=1;
        
        lps[0] = 0;
        while(i<needle.length()){
            
            if(needle.charAt(i) == needle.charAt(j)){
                j++;
                lps[i]=j;
                i++;
            }
            else if(j > 0 && needle.charAt(i) != needle.charAt(j)){                
                j = lps[j-1];
            }
            else if(j== 0 && needle.charAt(i) != needle.charAt(j)){
                lps[i] = 0;
                i++;
            }
            
            
        }
        
        
        return lps;
    }
    
    
}