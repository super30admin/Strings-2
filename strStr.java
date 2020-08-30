//TC: O(m*n)
//SC: O(1)
class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length(); int n = needle.length();
        if(n>m) return -1;
        if(m == 0 || n == 0) return 0;
        int i = 0; int j = 0;
        while(i < m){
            if(haystack.charAt(i) == needle.charAt(j)){
                    int temp = i;
                    while(temp < m && j<n){
                            if(haystack.charAt(temp) == needle.charAt(j)){
                                temp++; j++;
                            }
                            else{
                                break;
                            }
                        }
                    if(j == n) return i;
                }
            j = 0;
            i++;
        }
        return -1;
    }
}

//TC: O(m+n)
//SC: O(n)
class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length(); int n = needle.length();
        if(n == 0) return 0;
        if(n > m) return -1;
        int[] lps = lps(needle);
        int i = 0; int j = 0;
        while(i < m && j < n){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++; j++;
                if(j==n){
                    return i-n;
                }
            }
            else if(j>0){
                j = lps[j-1];
            }
            else if(j==0){
                i++;
            }
        }
        return -1;
    }
    
    private int[] lps(String needle){
        int[] lps = new int[needle.length()];
        int i = 1; int j = 0;
        while(i < needle.length()){
            if(needle.charAt(i) == needle.charAt(j)){
                j++;
                lps[i] = j;
                i++;
            }
            else if(j > 0){
                j = lps[j-1];
            }
            else if (j == 0){
                lps[i] = 0;
                i++;
            }
        }
        return lps;
    }
}
