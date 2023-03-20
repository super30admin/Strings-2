// brute force
public class FindIndexOfFirstOccurrence {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        int i = 0;
        int j = 0;
        while(i<=m-n){
            if(haystack.charAt(i)==needle.charAt(j)){
                int k = i;
                while(haystack.charAt(k)==needle.charAt(j)){
                    k++;
                    j++;
                    if(j==n) return i;
                }
                j=0;
            }
            i++;
        }
        return -1;
    }
}

//TC - O(m*n)
//m - length of haystack string
//n - length of  needle string

// KMP Algorithm
public class FindIndexOfFirstOccurrence {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();

        if( m < n ) return -1;
        
        //haystack ptr
        int i = 0;
        //needle ptr
        int j = 0;

        int lps[] = lps(needle);

        while(i < m){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;

                if(j == n)
                    return i-n;
            }
            else if(haystack.charAt(i) != needle.charAt(j) && j > 0){
                j = lps[j-1];
            }
            else if(haystack.charAt(i) != needle.charAt(j) && j == 0){
                i++;
            }
        }
        return -1;
    }

    private int[] lps(String needle){
        int i = 1;
        int j = 0;

        int[] lps = new int[needle.length()];
        lps[0] = 0;

        while(i < needle.length()){
            if(needle.charAt(j) == needle.charAt(i)){
                j++;
                lps[i] = j;
                i++;
            }
            else if(needle.charAt(j) != needle.charAt(i) && j > 0){
                j = lps[j-1];
            }
            else if(needle.charAt(j) != needle.charAt(i) && j == 0){
                lps[i] = 0;
                i++;
            }
        }
        return lps;
    }
}