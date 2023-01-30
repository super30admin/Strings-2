// Time: O(m+n)
// Space: O(1) 

class StrStr {
    public int strStr(String haystack, String needle) {
        if (haystack == null || haystack.length() == 0 || needle == null || needle.length() ==0) return -1;
        
        int i=0,j=0,k=0;
        int m = haystack.length();
        int n = needle.length();

        while (i <= m-n){
            if (haystack.charAt(i) == needle.charAt(0)){
                k=i;
                j=0;
                while (haystack.charAt(k) == needle.charAt(j)){
                    k++;
                    j++;
                    if (j==n) return i;
                }
            }
            i++;
        }
        return -1;
    }
}