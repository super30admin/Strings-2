//Time Complexity: O(mn)
//Space Complexity: O(1) 

/*
 * In this approach we run a loop till the length reaches m -n, if the first char needle is equal to the haystack then we find the first occurence if needle is present,
 * If we find the whole needle string then we return that index. 
*/
//brute force
class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if(m<n)return -1;
        int i=0;
        while(i<= m-n){
            if(haystack.charAt(i) == needle.charAt(0)){
                int k=i;
                int j=0;
                while(haystack.charAt(k) == needle.charAt(j)){
                    k++;j++;
                    if(j==n)return i;
                }
            }
            i++;
        }
        return -1;
    }
}

//Time Complexity: O(m)
//Space Complexity: O(1) 
class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        int i =0; //pointer on source
        int j = 0; //pointer on pattern
        if(m<n)return -1;
        int [] lps = lps(needle);
        while(i<m){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;  j++;
                if(j == n){
                    return i-n;
                }
            }else if(haystack.charAt(i) != needle.charAt(j) && j>0){
                j = lps[j-1];
            }else if(haystack.charAt(i) != needle.charAt(j) && j == 0){
                i++;
            }
        }
        return -1;
    }
    private int [] lps(String needle){
        int [] lps = new int[needle.length()];
        int i =1; int j =0;
        lps[0] = 0;
        while(i < needle.length()){
            if(needle.charAt(i) == needle.charAt(j)){
                j++;
                lps[i]=j;
                i++;
            }else if(needle.charAt(i) != needle.charAt(j) && j>0){
                j=lps[j-1]; 
            }else if(needle.charAt(i) != needle.charAt(j) && j==0){
                lps[i] =0;
                i++;
            }
        }
        return lps;
    }
}