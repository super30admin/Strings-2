//Time Complexity: O(m*n)
// Space Complexity: O(1)

public class ImplementStr {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if( m > n){
            return -1;
        }
        int i=0,j=0;

        boolean found = false;
        while(i<n){
            while( j < m && i< n){
                if(haystack.charAt(i) == needle.charAt(j) ){
                    if(j== m-1){
                        found = true;
                        return i-(m-1);
                    }
                    i++;
                    j++;
                }else{
                    i = (i-j)+1;
                    j=0;
                    break;
                }
            }

        }
        return -1;
    }
}
