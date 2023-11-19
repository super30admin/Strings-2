class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if(n > m) return -1; 
        
        int i = 0;
        int j=0;
        while(i <= m-n){
             if(haystack.charAt(i) == needle.charAt(j)){
                 int k = i;
                 while(haystack.charAt(k) == needle.charAt(j)){
                     k++;
                     j++;
                     if(j == n) return i;
                 }
                 j=0;
             }
            i++;
        }
        return -1;
    }
}

// Take 2 pointers on each string and iterate until you find a mismatch. Once you find a mismatch, move pointer (j) on needle string back to 0’th index and reset pointer i of haystack string to i=k+1 where k initially was present at 0 and it is to keep track of index we wanna return
