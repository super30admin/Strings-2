//KMP algorithm
//time o(m+n)
//space o(n)

class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        //given in the question
        if(needle.length() == 0)
            return 0;
        
        int i=0, j=0;
        int[] lps = lps(needle, n);
        while(i<m) {
            if(haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }
            if(j==n) {
                //start index of needle in the haystack array
                return i-n;
            }   
            else if(i<m && j>0 && haystack.charAt(i) != needle.charAt(j)) {
                j=lps[j-1];
            }
            else if(i<m && j==0 && haystack.charAt(i) != needle.charAt(j)) {
                i++;
            }
        }
        return -1;
    }
    
    
    //lower prefix and suffix array
    private int[] lps(String needle, int n) {
        int[] lps = new int[n];
        lps[0] = 0;
        int i=1, j=0;
        while(i<n) {
            //case1
            if(needle.charAt(i) == needle.charAt(j)) {
                j++;
                lps[i] = j;
                i++;
            } //case2 squeezing prefix window
            else if(j>0 && needle.charAt(i) != needle.charAt(j)) {
                j = lps[j-1];
            } //case3
            else if(j==0 && needle.charAt(i) != needle.charAt(j)) {
                lps[i] = 0;
                i++;
            }
        }
        return lps;
    }
}


//Bruteforce
//time o(mn)
//space o(1)

class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        //given in the question
        if(needle.length() == 0)
            return 0;
        
        int i=0, j=0;
        
        while(i< m-n+1) {
            if(haystack.charAt(i) == needle.charAt(j)) {
                int temp = i;
                while(j<n && temp<m && haystack.charAt(temp) == needle.charAt(j)) {
                    temp++;
                    j++;
                }
                if(j == n) {
                    return i;
                }
            }
            i++;
            j=0; //initilize to first index
        }
        return -1;
    }
}