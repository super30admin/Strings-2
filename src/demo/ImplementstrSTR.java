package demo;

//Time: o(m*n)
//Space: O(n)
//Leetcode yes

class Solution {
    public int strStr(String haystack, String needle) {
        int N = haystack.length();
        int M = needle.length();
       if(needle == "" || needle == null ||
          needle.length() ==0 ) return 0;
        if(haystack == "" || haystack == null ||
           haystack.length() == 0 || haystack.length() < needle.length()) return -1;
        
       int[] KMP = KMPHelper(needle, M);
        int i =0;
        int j =0;
        while(i< N ){
             if(haystack.charAt(i) == needle.charAt(j)){
                 i++;
                 j++;
             }
            if(j == M){
                 return i-j;
             }else if(i < N && haystack.charAt(i) != needle.charAt(j) && j > 0){
                 j = KMP[j-1];
             }else if(i < N && haystack.charAt(i) != needle.charAt(j) && j== 0){
                 i++; 
            }
        }
        
        return -1;
    }
    
    private int[] KMPHelper(String p, int M){
        int[] KMP = new int[M];
        
        int i =1;
        int j =0;
        
        while(i < M){
            if(p.charAt(i) == p.charAt(j)){
                j++;
                KMP[i] = j;
                i++;
            }else if(p.charAt(i) != p.charAt(j) && j > 0){
                j = KMP[j-1];
            }else if(p.charAt(i) != p.charAt(j) && j == 0){
                KMP[i] = j;
                i++;
            }
        }
        
        return KMP;
    }
}